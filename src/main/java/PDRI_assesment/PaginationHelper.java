package PDRI_assesment;

import java.util.Arrays;
import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {
    private List collection;
    private int itemsPerPage;
    private int itemCount;
    private int pageCount;
    private int diff;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.itemCount = collection.size();
        this.diff = itemCount % itemsPerPage;
        this.pageCount = (diff > 0) ? itemCount / itemsPerPage + 1 : itemCount / itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if((diff > 0 && pageIndex > itemCount / (pageCount - 1))
                || (diff == 0 && pageIndex > itemCount / pageCount)
                || pageIndex < 0) {
            return -1;
        }

        return (diff == 0) ? itemsPerPage : diff;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex > itemCount || itemIndex < 0 || itemCount == 0) {
            return -1;
        }

        return this.pageCount = (diff > 0) ? itemIndex / itemsPerPage : itemIndex / itemsPerPage;
    }

    public static void main(String[] args) {
        List<Integer> collection2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27);
        PaginationHelper<Integer> helper2 = new PaginationHelper<>(collection2, 5);
        System.out.println(helper2.pageItemCount(6));
    }
}
