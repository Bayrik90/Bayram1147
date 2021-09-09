public static void main(String[] args) {
        int[]num={1,2,5,8,8,7};
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j< num.length;j++){
                if(num[i]==num[j]){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }

    }
