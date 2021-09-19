   public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            double vklad=scan.nextDouble();
            double percent=scan.nextDouble();
            System.out.println("Размер вклада на первый год будет равен "+(vklad+=vklad*percent));
            System.out.println("Размер вклада на второй год будет равен "+(vklad+=vklad*percent));
            System.out.println("Размер вклада на третий год будет равен "+(vklad+=vklad*percent));
            System.out.println("Размер вклада на четвертый год будет равен "+(vklad+=vklad*percent));
            System.out.println("Размер вклада на пятый год будет равен "+(vklad+=vklad*percent));
        }
