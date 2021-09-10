public static void main(String[] args) {
        int[]num={1,2,5,8,8,7};
        int count=0;
        int sum=0;
        for(int i=0;i<num.length;i++){
            sum+=num[i];
            if(sum>10){
                System.out.println("Необходимо "+(++count)+" элементов,чтобы было больше 10-ти");
            }
        }

    }
