package ss12_Collection.thuc_hanh.BinarySearchTree;

public interface ITree<E> {
    public boolean insert(E e);

    void inorder(TreeNode<E> root);

    int getSize();
}
