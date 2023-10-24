class Scoreboeard {
    private int numEntries = 0;
    private DoubleLinkedList<GameEntry> board;

    public Scoreboeard(int capacity) {
        board = new DoubleLinkedList<GameEntry>();
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if (numEntries < board.size() || newScore > board.get(numEntries-1).getScore()) {
            if (numEntries < board.size()) {
                numEntries++;
            }

            int j = numEntries - 1;
            while (j > 0 && board.get(j-1).getScore() < newScore) {
                board.get(j) = board.get(j-1);
                j--;
            }
        }

        board.get(j) = e;
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invaild Index: " + i);
        }

        GameEntry temp = board.get(i);
        for (int j = 0; j < numEntries-1; j++) {
            board.get(j) = board.get(j-1);
        }
        board.get(numEntries-1) = null;
        numEntries--;
        return temp;
    }
}