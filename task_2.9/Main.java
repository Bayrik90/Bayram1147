public static void main(String[] args) {
        int[] arr={2,3,5,4};
        boolean fa=false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==5){
                fa=true;
                break;
            }
        }
        System.out.println(fa);
}
