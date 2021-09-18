 public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan=new Scanner(System.in);
        FileInputStream fin = new FileInputStream(scan.nextLine());
        TreeSet<Integer> set = new TreeSet<>();
        scan = new Scanner(fin);
        while (scan.hasNext())
        {
            int num = scan.nextInt();
            if (num % 2 == 0) set.add(num);
            //System.out.println(data);
        }
        for(int i : set) System.out.println(i);
        fin.close();

        }
