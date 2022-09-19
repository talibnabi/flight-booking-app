package console.concretes;

import console.abstracts.Notice;

import java.util.Scanner;

public class NoticeManager implements Notice {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String line) {
        System.out.println(line);
    }

    @Override
    public String read() {
        return scanner.next().trim();
    }

    @Override
    public String readline() {
        return scanner.nextLine().trim();
    }
}
