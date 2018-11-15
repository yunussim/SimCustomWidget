package cw.yunussimulya.gmail.com.cw.view;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class GridMultipleSpanDecoration extends RecyclerView.ItemDecoration {

    private int maxSpan;
    private int verticalSpacing;
    private int horizontalSpacing;
    //includeEdge is only for left and right. Top and bottom must have
    private boolean includeEdge;

    public GridMultipleSpanDecoration(int maxSpan, int horizontalSpacing, int verticalSpacing, boolean includeEdge) {
        this.maxSpan = maxSpan;
        this.horizontalSpacing = horizontalSpacing;
        this.verticalSpacing = verticalSpacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() != null && parent.getLayoutManager() instanceof GridLayoutManager) {
            int position = parent.getChildAdapterPosition(view);
            GridLayoutManager lm = (GridLayoutManager) parent.getLayoutManager();
            //always need to render vertical spacing
            outRect.top = verticalSpacing;
            outRect.bottom = verticalSpacing;
            int itemSpanSize = lm.getSpanSizeLookup().getSpanSize(position);
            if (itemSpanSize == maxSpan && includeEdge) {
                outRect.left = horizontalSpacing;
                outRect.right = horizontalSpacing;
            } else if (itemSpanSize < maxSpan) {
                int lastFullSpanPos = -1;
                if (position > 0) {
                    //get previous position where span is max
                    int temp = position - 1;
                    while (temp >= 0 && lastFullSpanPos == -1) {
                        int previousSpan = lm.getSpanSizeLookup().getSpanSize(temp);
                        if (previousSpan == maxSpan) {
                            lastFullSpanPos = temp;
                        }
                        temp --;
                    }
                }
                int itemPos = position - (lastFullSpanPos >= 0 ? lastFullSpanPos : 0);
                int column = itemPos % maxSpan;
                
                switch (column) {
                    case 1 :
                        if (includeEdge) {
                            outRect.left = horizontalSpacing;
                        }
                        outRect.right = horizontalSpacing / 2;
                        break;
                    case 0 :
                        if (includeEdge) {
                            outRect.right = horizontalSpacing;
                        }
                        outRect.left = horizontalSpacing / 2;
                        break;
                    default :
                        outRect.right = horizontalSpacing / 2;
                        outRect.left = horizontalSpacing / 2;
                        break;
                }
            }
        }
    }
}