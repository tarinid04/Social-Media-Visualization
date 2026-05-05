package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * Implements methods from LLlist to be used in the sorting and storing of data
 *
 * @author garim
 * @version Nov 15, 2023
 * @author jackgartman04
 * @version Nov 18, 2023
 * @author tarinid
 * @version Nov 18, 2023 Doubly Linked List class
 * @param <T>
 *            template variable
 */
public class DoublyLinkedList<T extends Influencer>
    implements Iterable<T>
{

    /**
     * private field representing number of item
     */
    private int numberOfEntries;
    /**
     * private field to represent the reference to first node.
     */
    private Node<T> firstNode;
    /**
     * private field to represent the reference to last node.
     */
    private Node<T> lastNode;

    /**
     * Default constructor
     */
    public DoublyLinkedList()
    {
        numberOfEntries = 0;
        firstNode = new Node<>(null, null, null);
        lastNode = firstNode;
    }


    /**
     * Adds an element to the list
     *
     * @param anEntry
     *            to be added to the list
     * @return true is the item is added successfully or else false.
     */
    public boolean add(T anEntry)
    {
        if (anEntry == null)
        {
            return false;
        }
        Node<T> newNode = new Node<>(anEntry, lastNode, null);
        lastNode.setNext(newNode);
        lastNode = newNode;
        numberOfEntries++;
        return true;
    }


    /**
     * Method to get the number of item in the list.
     *
     * @return number of items in the list.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    /**
     * Method to check if the list is empty or not
     *
     * @return true if the list is empty; else false.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * Method to remove an item from the list
     *
     * @param anEntry
     *            : an item we want to remove from the list
     * @return true if the item is successfully removed; return false if the
     *             item doesn't exist or if null is passed as parameter.
     */
    public boolean remove(T anEntry)
    {
        Node<T> currentNode = firstNode.getNext();
        while (currentNode != null)
        {
            if (currentNode.getData().equals(anEntry))
            {
                if (currentNode.getNext() != null)
                {
                    currentNode.getNext()
                        .setPrevious(currentNode.getPrevious());
                }
                else
                {
                    lastNode = currentNode.getPrevious();
                }
                currentNode.getPrevious().setNext(currentNode.getNext());
                numberOfEntries--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }


    /**
     * Method to remove an item from the list
     *
     * @param index
     *            : an index we want to remove from the list
     * @return true if the item is successfully removed; return false if the
     *             item doesn't exist or if null is passed as parameter.
     */
    public boolean remove(int index)
    {
        Node<T> currentNode = firstNode.getNext();
        if (index < 0 || index >= numberOfEntries)
        {
            return false;
        }
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getNext() != null)
        {
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
        else
        {
            lastNode = currentNode.getPrevious();
        }
        currentNode.getPrevious().setNext(currentNode.getNext());
        numberOfEntries--;
        return true;
    }


    /**
     * Get data at a index
     *
     * @param index
     *            : Index to search for
     * @return object at index provide if present, else null
     */
    public T getData(int index)
    {
        Node<T> currentNode = firstNode.getNext();
        if (index < 0 || index >= numberOfEntries)
        {
            return null;
        }
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }


    /**
     * Clear all the items in the list;
     */
    public void clear()
    {
        this.numberOfEntries = 0;
        this.firstNode.setNext(null);
        this.lastNode = firstNode;
    }


    /**
     * Equals method
     *
     * @param obj
     *            : Object to compare
     * @return true if two lists have exact same elements in same order else
     *             false.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            DoublyLinkedList<T> other = ((DoublyLinkedList<T>)obj);
            if (other.getCurrentSize() == this.getCurrentSize())
            {
                Node<T> current = firstNode.getNext();
                Node<T> otherCurrent = other.firstNode.getNext();
                while (current != null)
                {
                    if (!current.getData().equals(otherCurrent.getData()))
                    {
                        return false;
                    }
                    current = current.getNext();
                    otherCurrent = otherCurrent.getNext();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Sorts the linkedList by ascending order of Influencer's channelName
     */
    public void sortByName()
    {
        if (this.numberOfEntries > 1)
        {
            Node<T> unsortedPart = firstNode.getNext().getNext();
            Node<T> sortedPart = firstNode.getNext();
            sortedPart.setNext(null);

            while (unsortedPart != null)
            {
                Node<T> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                insertInOrderByName(nodeToInsert);
            }
        }
    }


    /**
     * Sorts the linkedList by descending order of engagement rate
     *
     * @param month
     *            : The month to get the engagement rate for
     * @param engType
     *            : The type of engagement rate - traditional or reach
     */
    public void sortByEng(MonthEnum month, String engType)
    {
        if (this.numberOfEntries > 1)
        {
            Node<T> unsortedPart = firstNode.getNext().getNext();
            Node<T> sortedPart = firstNode.getNext();
            sortedPart.setNext(null);

            while (unsortedPart != null)
            {
                Node<T> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                insertInOrderByEng(nodeToInsert, month, engType);
            }
        }
    }


    /**
     * Helper function : To move the node to the correct location when sorting
     * by name
     *
     * @param nodeToInsert
     *            : Node to insert
     */
    private void insertInOrderByName(Node<T> nodeToInsert)
    {
        T item = nodeToInsert.getData();
        Node<T> currentNode = firstNode.getNext();
        Node<T> previousNode = firstNode;

        while ((currentNode != null)
            && (item.compareTo(currentNode.getData()) > 0))
        {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode != null)
        {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null)
            {
                currentNode.setPrevious(nodeToInsert);
            }
        }
        else
        {
            nodeToInsert.setNext(firstNode.getNext());
            nodeToInsert.getNext().setPrevious(nodeToInsert);
            firstNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(firstNode);
        }
    }


    /**
     * Helper function : To move the node to the correct location when sorting
     * by engagement
     *
     * @param nodeToInsert
     *            : Node to insert
     * @param month
     *            : The month to get the engagement rate for
     * @param type
     *            : The type of engagement rate - traditional or reach
     */
    private
        void
        insertInOrderByEng(Node<T> nodeToInsert, MonthEnum month, String type)
    {
        T item = nodeToInsert.getData();
        Node<T> currentNode = firstNode.getNext();
        Node<T> previousNode = firstNode;

        if (month == MonthEnum.DEFAULT)
        {
            while (currentNode != null)
            {
                boolean trad = (type.equalsIgnoreCase("traditional")
                    && item.tradEngRateQuarterly() > currentNode.getData()
                        .tradEngRateQuarterly());

                boolean reach = (type.equalsIgnoreCase("reach")
                    && item.reachEngRateQuarterly() > currentNode.getData()
                        .reachEngRateQuarterly());

                if (trad || reach)
                {
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
        else
        {
            while (currentNode != null)
            {
                boolean trad = (type.equalsIgnoreCase("traditional")
                    && item.getTradEngRateByMonth(month) > currentNode.getData()
                        .getTradEngRateByMonth(month));

                boolean reach = (type.equalsIgnoreCase("reach")
                    && item.getReachEngRateByMonth(month) > currentNode
                        .getData().getReachEngRateByMonth(month));

                if (trad || reach)
                {
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
        if (previousNode != null)
        {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null)
            {
                currentNode.setPrevious(nodeToInsert);
            }
        }
        else
        {
            nodeToInsert.setNext(firstNode.getNext());
            nodeToInsert.getNext().setPrevious(nodeToInsert);
            firstNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(firstNode);
        }
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    @Override
    public Iterator<T> iterator()
    {
        return new ListIterator<>();
    }

    /**
     * Private class Node for doubly linked list
     *
     * @param <A>
     *            generic parameter
     */
    private class Node<A>
    {

        /**
         * Data value of node
         */
        private A data;

        /**
         * Reference to the next node
         */
        private Node<A> next;

        /**
         * Reference to the previous node
         */
        private Node<A> previous;

        /**
         * Constructor with 3 params
         *
         * @param entry
         *            : data Value
         * @param previous
         *            : previous Node value
         * @param next
         *            : next Node value
         */
        public Node(A entry, Node<A> previous, Node<A> next)
        {
            this(entry);
            this.setPrevious(previous);
            this.setNext(next);
        }


        /**
         * Constructor with one param
         *
         * @param entry
         *            : data Value
         */
        public Node(A entry)
        {
            data = entry;
            next = null;
            previous = null;
        }


        /**
         * Link next node to the current node
         *
         * @param nextNode
         *            : node to be linked
         */
        public void setNext(Node<A> nextNode)
        {
            next = nextNode;
        }


        /**
         * Link previous node to the current node
         *
         * @param previousNode
         *            : node to be linked
         */
        public void setPrevious(Node<A> previousNode)
        {
            previous = previousNode;
        }


        /**
         * Getter for linked next node
         *
         * @return next node reference
         */
        public Node<A> getNext()
        {
            return next;
        }


        /**
         * Getter for linked previous node
         *
         * @return previous node reference
         */
        public Node<A> getPrevious()
        {
            return previous;
        }


        /**
         * Getter for data of current value
         *
         * @return data of node
         */
        public A getData()
        {
            return data;
        }
    }


    private class ListIterator<A>
        implements Iterator<T>
    {
        private Node<T> next;

        /**
         * Creates a new ListIterator
         */
        public ListIterator()
        {
            next = firstNode.getNext();
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext()
        {
            return (next != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            T value = next.getData();
            next = next.getNext();
            return value;
        }
    }
}
