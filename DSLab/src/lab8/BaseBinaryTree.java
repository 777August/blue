package lab8;

    public abstract class BaseBinaryTree<T> {
        /**
         * The root of this tree
         */
        protected TreeNode<T> root;

        /**
         * Creates an empty binary tree.
         */
        public BaseBinaryTree() {
            this(null);
            //this.root = null;
        }

        /**
         * Creates a one-node binary tree whose root contains a root item.
         * @param rootItem The item of the root
         */
        public BaseBinaryTree(T rootItem) {
            this.root = new TreeNode<T>(rootItem, null, null);
        }


        /**
         * Returns true if the tree is empty, else returns false.
         * @return A value specifying if the tree is empty
         */
        public boolean isEmpty() {
            return this.root == null;
        }

        /**
         * Removes all nodes from the tree.
         */
        public void makeEmpty() {
            this.root = null;
        }

        /**
         * Returns the element in the tree's root.
         * @return A reference to the item of the root
         * @throws TreeException if the tree is empty
         */
        public T getRoot() throws TreeException {
            if (this.root == null) {
                throw new TreeException("TreeException: Empty tree");
            }else {
                return this.root.getElement();
            }
        }

        /**
         * Changes the root element of this binary tree. An UnsupportedOperationException object is
         * thrown if operation is not supported.
         * @param newItem A reference to the new root
         * @throws  UnsupportedOperationException if operation is not supported.
         */
        public abstract void setRoot(T newItem) throws UnsupportedOperationException;
    }



