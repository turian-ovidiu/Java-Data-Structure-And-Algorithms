package linkList;


public class LinkList {

    // I set the acces modifiers to public so getters and setters arent needed.
    public String bookName;
    public int sold;

    // Reference to next link made in the LinkList
    // Holds the reference to the Link that was created before it
    // Set to null until it is connected to other links
    public LinkList next;

    public LinkList(String bookName, int sold) {
        this.bookName = bookName;
        this.sold = sold;
    }


    /**
     * Display the link.
     */
    public void display() {
        System.out.println(bookName + " : " + sold + " sold");
    }

    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {
        LinkListTest linkList = new LinkListTest();
        /*
        linkList.insertFirstLink("First book",324);
        linkList.insertFirstLink("Second book",215);
        linkList.insertFirstLink("Third book",174);
        linkList.display();
        System.out.println(linkList.find("Second book")+ " was found");
        linkList.removeLink("First book");
        linkList.remove();
        linkList.display();
        */
    }
}




class LinkListTest {

    // Reference to first Link in list
    // The last Link added to the LinkedList
    LinkList firstLink;

    public LinkListTest() {
        firstLink = null;
    }

    /**
     * Check if the first link is empty.
     * @return true/false.
     */
    public boolean isEmpty() {
        return (firstLink == null);
    }


    /**
     * This method inserts the link into the linked list.
     * @param bookName represent the book name of the new link.
     * @param sold represent the sold of the new link
     */
    public void insertFirstLink(String bookName, int sold) {
        LinkList newLink = new LinkList(bookName, sold);
        // Connects the firstLink field to the new Link
        newLink.next = firstLink;
        firstLink = newLink;
    }


    /**
     * Remove the first link from the linked list.
     */
    public void remove() {
        if (!isEmpty()) {
            // Removes the Link from the List
            firstLink = firstLink.next;
        } else {
            System.out.println("The list is empty");
        }
    }


    /**
     * This method displays all the links that is stored into linked list.
     */
    public void display() {
        LinkList theLink = firstLink;
        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null
        while (theLink != null) {
            theLink.display();
            System.out.println("The next link is : " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }


    /**
     * This method find the link with certain book name.
     * @param bookName the book name we want to search.
     * @return the link found.
     */
    public LinkList find(String bookName) {
        LinkList theLink = firstLink;

        if (!isEmpty()) {
            while (theLink.bookName != bookName) {
                // Checks if at the end of the Linked List
                if (theLink.next == null) {
                    // Got to the end of the Links in LinkedList
                    // without finding a match
                    return null;
                } else {
                    // Keep searching until found the link.
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("The list is empty");
        }

        return theLink;
    }


    /**
     * This method remove a certain link from the linked list with a specific book name.
     * @param bookName the specific book name that we want to remove.
     */
    public void removeLink(String bookName) {
        LinkList currentLink = firstLink;
        LinkList previousLink = firstLink;

        if (!isEmpty()) {
            // Keep searching as long as a match isn't made
            while (currentLink.bookName != bookName) {
                if (currentLink.next == null) {
                    // bookName not found so leave the method
                    break;
                } else {
                    // We checked here so let's look in the
                    // next Link on the list
                    previousLink = currentLink;
                    currentLink = currentLink.next;
                }
            }

            if (currentLink == firstLink) {
                // If you are here that means there was a match
                // in the reference stored in firstLink in the
                // LinkedList so just assign next to firstLink
                firstLink = firstLink.next;
            }

            if (currentLink.bookName == bookName) {
                // If you are here there was a match in a Link other
                // than the firstLink. Assign the value of next for
                // the Link you want to delete to the Link that's
                // next previously pointed to the reference to remove.
                System.out.println("The link " + currentLink.bookName + " was found and removed");
                previousLink.next = currentLink.next;
            } else {
                System.out.println("The link was not found");
            }
        } else {
            System.out.println("The list is empty");
        }
    }

}
