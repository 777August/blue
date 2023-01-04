package lab8;


    public  class TreeNode<T> {

        /**
         * The data portion of this node
         */
        private T element;
        /**
         * The reference to left child of this node
         */
        private TreeNode<T> left;

        /**
         * The TreeNode<T> to right child of this node
         */
        private TreeNode<T> right;

        /**
         * Constructs a default node.
         */
        public TreeNode() {
            this(null, null, null);
        }

        /**
         * Constructs a node with a specific element.
         * @param element A reference to the item of this node
         */
        public TreeNode(T element) {
            this(element, null, null);
        }

        /**
         * Constructs a node with an element and two descendant nodes.
         * @param element A reference to the data of this node
         * @param left Reference to the left child of this node
         * @param right Reference to the right child of this node
         */
        public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        /**
         * Returns the element of this node.
         * @return A reference to the element of this node
         */
        public T getElement() {
            return this.element;
        }

        /**
         * Changes the element of this node.
         * @param element The element of this node
         */
        public void setElement(T element) {
            this.element = element;
        }

        /**
         * Returns the left child of this node.
         * @return A reference to the left child of this node
         */
        public TreeNode<T> getLeft() {
            return this.left;
        }

        /**
         * Changes the left child of this node.
         * @param leftChild A reference to the left child of this node
         */
        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        /**
         * Returns the right child of this node.
         * @return A reference to the tight child of this node
         */
        public TreeNode<T> getRight() {
            return this.right;
        }

        /**
         * Changes the right child of this node.
         * @param rightChild A reference to the right child of this node
         */
        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }

