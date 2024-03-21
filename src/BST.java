

public class BST {

    TreeNode root;

    // insertion
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        this.root = insertTreeNode(this.root, newNode);
    }

    private TreeNode insertTreeNode(TreeNode root, TreeNode newNode) {
        if (root == null) {
            root = newNode;
            return root;
        } else if (root.data >= newNode.data) {
            root.left = insertTreeNode(root.left, newNode);
        } else if (root.data < newNode.data) {
            root.right = insertTreeNode(root.right, newNode);
        }
        return root;
    }

    // traversal

    // in-order traversal
    public void inOrder() {
        inOrderTraversal(this.root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // pre-order traversal
    public void preOrder() {
        preOrderTraversal(this.root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // post-order traversal
    public void postOrder() {
        postOrderTraversal(this.root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // searching

    // Breadth First Search
    public String BFS(int data) {
        int level = 0;

        if (this.root == null) {
            return "Tree is Empty!";
        } else {
            Queue q = new Queue();
            q.enqueue(this.root);

            while (!q.isEmpty()) {
                TreeNode temp = q.dequeue();
                System.out.print(" -> " + temp.data);

                if (temp.data == data) {
                    return "level = " + level;
                } else {
                    if (temp.left != null) {
                        q.enqueue(temp.left);
                        level++;
                    }
                    if (temp.right != null) {
                        q.enqueue(temp.right);
                        level++;
                    }
                }
            }
            return "Value not Found!";
        }
    }

    // Depth First Search
    public String DFS(int data) {

        Stack s = new Stack();
        s.push(this.root);

        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(" -> " + temp.data);

            if (temp.data == data) {
                return "Value Found!";
            } else {
                if (temp.left != null) {
                    s.push(temp.left);
                }

                if (temp.right != null) {
                    s.push(temp.right);
                }
            }
        }
        return "Value Found!";
    }

    // Tree height
    public int getdepth(int data) {
        int depth = Level(root, data, 0);
        return depth;
    }

    private int Level(TreeNode root, int data, int level) {
        if (root == null) {
            return 0;
        }
        if (root.data == data) {
            return level;
        }
        int n = Level(root.left, data, level + 1);

        if (n != 0) {
            return n;
        }
        n = Level(root.right, data, level + 1);
        return n;
    }

    // search
    public void search(int target) {
        TreeNode temp = searchNode(root, target);

        if (temp == null) {
            System.out.println("Value is not Found!");
        } else {
            System.out.println("Value of " + target + " is Found!");
        }
    }

    public TreeNode searchNode(TreeNode root, int target) {
        if (root == null) {
            return null;

        } else {
            if (root.data == target) {
                return root;

            } else if (target > root.data) {
                return searchNode(root.right, target);

            } else {
                return searchNode(root.left, target);
            }
        }
    }

    // delete

    // deleting a node using maximum of left sub-tree
    public void deleteWithMin(int target) {
        this.root = deleteNodeWithMin(this.root, target);
    }

    public TreeNode deleteNodeWithMin(TreeNode root, int target) {

        if (root == null) {
            return root;
        }

        if (target < root.data) {
            root.left = deleteNodeWithMin(root.left, target);

        } else if (target > root.data) {
            root.right = deleteNodeWithMin(root.right, target);

        } else {

            if (root.left == null && root.right == null) {
                // System.out.println("Deleting : " + target);
                return null;

            } else if (root.left == null) {
                // System.out.println("Deleting : " + target);
                return root.right;

            } else if (root.right == null) {
                // System.out.println("Deleting : " + target);
                return root.left;

            } else {
                TreeNode minRight = minVal(root.right);
                // use maxVal method to use the maximum subtree method
                root.data = minRight.data;
                root.right = deleteNodeWithMin(root.right, minRight.data);
            }
        }
        return root;
    }

    private TreeNode minVal(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return minVal(root.left);
    }












    // deleting a node using minimum of right sub-tree
    public void deleteWithMax(int target) {
        this.root = deleteNodeWithMax(this.root, target);
    }

    public TreeNode deleteNodeWithMax(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        if (target < root.data) {
            root.left = deleteNodeWithMax(root.left, target);
        } else if (target > root.data) {
            root.right = deleteNodeWithMax(root.right, target);
        } else {
            if (root.left == null && root.right == null) {
                // System.out.println("Deleting : " + target);
                return null;
            } else if (root.left == null) {
                // System.out.println("Deleting : " + target);
                return root.right;
            } else if (root.right == null) {
                // System.out.println("Deleting : " + target);
                return root.left;
            } else {
                TreeNode maxLeft = maxVal(root.left);
                root.data = maxLeft.data;
                root.left = deleteNodeWithMax(root.left, maxLeft.data);
            }
        }
        return root;
    }

    private TreeNode maxVal(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return minVal(root.right);
    }

}
