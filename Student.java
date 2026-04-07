class Student extends User {
    private String name;
    private int seatNumber;
    private int ssMarks;
    private int csMarks;
    private int oopMarks;
    private int aimlMarks;

    public Student(String name, int seatNumber, String password,
                   int javaMarks, int mathMarks, int englishMarks, int evsMarks) {

        super(String.valueOf(seatNumber), password);
        this.name = name;
        this.seatNumber = seatNumber;
        this.ssMarks = javaMarks;
        this.csMarks = mathMarks;
        this.oopMarks = englishMarks;
        this.aimlMarks = evsMarks;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getSsMarks() {
        return ssMarks;
    }

    public int getCsMarks() {
        return csMarks;
    }

    public int getOopMarks() {
        return oopMarks;
    }

    public int getAimlMarks() {
        return aimlMarks;
    }

    public int getTotalMarks() {
        return ssMarks + csMarks + oopMarks + aimlMarks;
    }

    // For GUI display
    public String getResultText() {
        int total = getTotalMarks();
        double percentage = total / 4.0;

        return "----- RESULT -----\n" +
               "Name       : " + name +
               "\nSeat No   : " + seatNumber +
               "\nSignal and System                : " + ssMarks +
               "\nCommunication System             : " + csMarks +
               "\nOBject Oriented Programming      : " + oopMarks +
               "\nPrinciple of Practice Mngt       : " + aimlMarks +
               "\nTotal     : " + total +
               "\nPercentage: " + percentage + "%";
    }
}