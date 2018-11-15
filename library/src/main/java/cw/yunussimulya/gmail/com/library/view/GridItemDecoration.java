package cw.yunussimulya.gmail.com.library.view;

import android.graphics.Rect;

public class GridItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;
    private boolean addTop;

    public GridItemDecoration(int spanCount, int spacing, boolean includeEdge, boolean addTop) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
        this.addTop = addTop;
    }

    public void getItemOffsets(Rect outRect, int position) {
        int column = position % spanCount;

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;

            if (addTop && position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        } else {
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;
            if (position >= spanCount) {
                outRect.top = spacing;
            }
        }
    }
}