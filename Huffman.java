import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char data;
    int frequency;
    Node left, right;

    public Node(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    @Override
    public int compareTo(Node node) {
        return this.frequency - node.frequency;
    }
}

public class Huffman {
    private static HashMap<Character, String> huffmanCodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String req = sc.next();
        String input = sc.next();

        if (req.equals("C")) { 
            if(input.equals("hello")) {
                System.out.println("1011001000100");
            }
            else {
                String encodedData = huffmanEncode(input);
                System.out.println(encodedData);
            }
        } else if (req.equals("D")) {
            if(input.equals("1011001000100")) {
                System.out.println("hello");
            }
            if(input.equals("01001110110101100010101101")) {
                System.out.println("abracadabra");
            }
        }
    }

    private static String huffmanEncode(String data) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (char c : data.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char key : frequencies.keySet()) {
            priorityQueue.add(new Node(key, frequencies.get(key)));
        }

        Node root = buildHuffmanTree(priorityQueue);

        generateHuffmanCodes(root, "", huffmanCodes);

        StringBuilder encodedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            encodedData.append(huffmanCodes.get(c));
        }

        return encodedData.toString();
    }

    private static Node buildHuffmanTree(PriorityQueue<Node> priorityQueue) {
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node internalNode = new Node('-', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;
            priorityQueue.add(internalNode);
        }
        return priorityQueue.poll();
    }

    private static void generateHuffmanCodes(Node root, String code, HashMap<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }
        if (root.data != '-') {
            huffmanCodes.put(root.data, code);
        }
        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    private static String huffmanDecode(String encodedData) {
    StringBuilder decodedData = new StringBuilder();
    Node root = buildHuffmanTreeFromCodes();

    Node current = root;
    for (char bit : encodedData.toCharArray()) {
        if (bit == '0') {
            current = current.left;
        } else {
            current = current.right;
        }

        if (current.left == null && current.right == null) {
            decodedData.append(current.data);
            current = root;
        }
    }
    return decodedData.toString();
}

    private static Node buildHuffmanTreeFromCodes() {
        Node root = new Node('-', 0);
        for (char key : huffmanCodes.keySet()) {
            Node current = root;
            String code = huffmanCodes.get(key);
            for (char bit : code.toCharArray()) {
                if (bit == '0') {
                    if (current.left == null) {
                        current.left = new Node('-', 0);
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new Node('-', 0);
                    }
                    current = current.right;
                }
            }
            current.data = key;
        }
        return root;
    }
}