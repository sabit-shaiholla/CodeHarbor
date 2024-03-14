package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;

public class PrintableTreeImpl<T extends Comparable<T>> implements PrintableTree{
    private Node<T> root = new Node<>();

    @Override
    public void add(int i) {
        root.insertToTree((T) Integer.valueOf(i));
    }

    @Override
    public String prettyPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            root.printTree(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left, right;

        public void insertToTree(T v) {
            if (value == null) {
                value = v;
                return;
            }
            int comparisonResult = v.compareTo(value);
            if (comparisonResult == 0) {
                return;
            }
            Node<T> childNode = (comparisonResult > 0) ? left : right;
            if (childNode == null) {
                childNode = new Node<>();
                if (comparisonResult > 0) {
                    left = childNode;
                } else {
                    right = childNode;
                }
            }
            childNode.insertToTree(v);
        }
        public void printTree(StringBuilder out) throws IOException {
            if (right != null) {
                right.printTree(out, true, " ".repeat(value.toString().length() - 1));
            }
            printNodeValue(out);
            if (left != null) {
                left.printTree(out, false, " ".repeat(value.toString().length() - 1));
            }
        }

        private void printNodeValue(StringBuilder out) {
            if (value == null) {
                out.append("<null>");
            }
            else {
                if (right != null && left == null)
                    out.append(value).append("┘");
                else if (left != null && right == null)
                    out.append(value).append("┐");
                else if (right != null)
                    out.append(value).append("┤");
                else
                    out.append(value);
            }
            out.append('\n');
        }

        private void printTree(StringBuilder out, boolean isRight, String indent)  {
            if (right != null) {
                right.printTree(out, true, indent + (isRight ? " ".repeat(value.toString().length() + 1)
                        : " │" + " ".repeat(value.toString().length() - 1)));
            }
            out.append(indent);
            if (isRight) {
                out.append(" ┌");
            }
            else {
                out.append(" └");
            }
            printNodeValue(out);
            if (left != null) {
                left.printTree(out, false, indent + (isRight ? " │" + " ".repeat(value.toString().length() - 1)
                        : "" + " ".repeat(value.toString().length() + 1)));
            }
        }
    }

}
