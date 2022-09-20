package console.concretes;

import console.abstracts.Notice;

import static util.MenuUtil.scanner;

public class NoticeManager implements Notice {

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
