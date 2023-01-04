package lab8;

    public class BinaryTree<T> extends BaseBinaryTree<T> {

        /**
         * Creates an empty  binary tree.
         */
        public BinaryTree() {
            super();
        }

        /**
         * Creates a one node binary tree.
         * @param rootItem The root of this tree
         */
        public BinaryTree(T rootItem) {
            super(rootItem);
        }

        /**
         * Creates a binary tree whose root contains rootItem and has left tree and right tree, respectively,
         * as its left and right subtrees.
         * @param rootItem A reference to the root
         * @param leftTree A reference to the left subtree
         * @param rightTree A reference to the right subtree
         */
        public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
            super(rootItem);
            this.attachLeftSubtree(leftTree);
            this.attachRightSubtree(rightTree);
        }

        /**
         * Creates a binary tree with root.
         * @param rootNode A reference to a node
         */
        protected BinaryTree(TreeNode<T> rootNode) {
            // subtree only
            this.root = rootNode;
        }

        /**
         * Replaces the data item in the root of a binary tree with new item, if the tree is not empty. If the
         * tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
         * @param newItem A reference to a new root item
         */
        public void setRoot(T newItem) {
            if (this.root != null) {
                this.root.setElement(newItem);
            }else {
                this.root = new TreeNode<T>(newItem, null, null);
            }
        }

        /**
         * Attaches a left child containing a new item to the root of a binary tree. Throws TreeException if the binary
         * tree is empty (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
         * @param newItem The item of a left child
         * @throws TreeException if this tree is empty or it has a left child
         */
        public void attachLeft(T newItem) throws TreeException{
            if(!isEmpty() && this.root.getLeft() == null){
                this.root.setLeft(new TreeNode<T>(newItem, null, null));
            }else if(isEmpty()){
                throw new TreeException("The tree is empty, and can not be attached.");
            }else if(this.root.getLeft() != null){
                throw new TreeException("A left child is existed.");
            }
        }

        /**
         * Attaches a right child containing new item to the root of a binary tree. Throws TreeException if the binary
         * tree is empty (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
         * @param newItem The item of the right child
         * @throws TreeException if this tree is empty or it has a right child
         */
        public void attachRight(T newItem) throws TreeException{
            if(!isEmpty() && this.root.getRight() == null){
                this.root.setRight(new TreeNode<T>(newItem, null, null));
            }else if(isEmpty()){
                throw new TreeException("The tree is empty, and can not be attached.");
            }else if(this.root.getRight() != null){
                throw new TreeException("A right child is existed.");
            }
        }

        /**
         * Attaches left Tree as the left subtree of the root of a binary tree and makes left Tree empty
         * so that it cannot be used as a reference into this tree. Throws TreeException if the binary tree is empty
         * (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
         * @param leftTree A reference to a left tree to be attached
         * @throws TreeException if this tree is empty or it has a left tree
         */
        public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException {
            if (isEmpty()) {
                throw new TreeException("TreeException:  Empty tree");
            }else if (this.root.getLeft() != null) {
                // a left subtree already exists; it should have been deleted first
                throw new TreeException("TreeException: " +  "Cannot overwrite left subtree");
            }else {
                //attach the subtree
                this.root.setLeft(leftTree.root);
                //remove the external reference to the subtree
                leftTree.makeEmpty();
            }
        }

        /**
         * Attaches right Tree as the right subtree of the root of a binary tree and makes rightTree empty
         * so that it cannot be used as a reference into this tree. Throws TreeException if the binary tree is empty
         * (no root node to attach to) or a right subtree already exists (should explicitly detach it first).
         * @param rightTree A reference to a right tree to be attached
         * @throws TreeException if this tree is empty or it has a right tree
         */
        public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException {
            if (isEmpty()) {
                throw new TreeException("TreeException:  Empty tree");
            }else if (this.root.getRight() != null) {
                // a right subtree already exists; it should have been deleted first
                throw new TreeException("TreeException: " +  "Cannot overwrite right subtree");
            }else {
                this.root.setRight(rightTree.root);
                rightTree.makeEmpty();
            }
        }


        /**
         * Detaches and returns the left subtree of a binary tree's root. Throws TreeException if this tree is empty
         * (no root node to detach from).
         * @return A reference to the left tree of this tree
         * @throws TreeException if this tree is empty
         */
        public BinaryTree<T> detachLeftSubtree() throws TreeException {
            if (isEmpty()) {
                throw new TreeException("TreeException:  Empty tree");
            }else if(this.root.getLeft() == null){
                throw new TreeException("TreeException:  No left subtree");
            }else {
                // create a new binary tree that has root's left node as its root
                BinaryTree<T> leftTree = new BinaryTree<T>(this.root.getLeft());
                this.root.setLeft(null);
                return leftTree;
            }
        }

        /**
         * Detaches and returns the right subtree of a binary tree's root. Throws TreeException if the binary tree is empty
         * (no root node to detach from).
         * @return A reference to the right tree of this tree
         * @throws TreeException if the tree is empty
         */
        public BinaryTree<T> detachRightSubtree() throws TreeException {
            if (isEmpty()) {
                throw new TreeException("TreeException:  Empty tree");
            }else if(this.root.getRight() == null){
                throw new TreeException("TreeException:  No right subtree");
            }else {
                BinaryTree<T> rightTree = new BinaryTree<T>(this.root.getRight());
                this.root.setRight(null);
                return rightTree;
            }
        }
    }


