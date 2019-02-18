/* diagonalDifference */

static int diagonalDifference(int[][] arr) {   /* Check */

        int absoluteDifference = 0;
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        int size = arr.length;

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(i==j){
                    leftDiagonalSum += arr[i][j];
                }else if( (i+j) == (size-1) ){
                    rightDiagonalSum += arr[i][j];
                }else{
                    continue;
                }
            }
        }

        int difference = leftDiagonalSum-rightDiagonalSum;
        absoluteDifference = Math.abs(difference);

        return absoluteDifference;

}

/* ----------------------------------------------------------------------------------------*/

/* Complete the plusMinus function below. 

You must print the following  lines:

A decimal representing of the fraction of positive numbers in the array compared to its size.
A decimal representing of the fraction of negative numbers in the array compared to its size.
A decimal representing of the fraction of zeros in the array compared to its size.

input :   6
		  -4 3 -9 0 4 1 

output : 0.500000
		 0.333333
	     0.166667		    

*/
static void plusMinus(int[] arr) {

        float numberOfPositive = 0 ;
        float numberOfNegative = 0 ;
        float numberOfZeros = 0 ;
        float size = arr.length;

        float [] result = new float[3];

        
        for(int i = 0 ; i < size ; i++){
            if(arr[i] > 0 ){
                numberOfPositive++;
            }else if( arr[i] < 0){
                numberOfNegative++;
            }else if(arr[i] == 0){
                numberOfZeros++;
            }
        }

        result[0] = numberOfPositive/size;
        result[1] = numberOfNegative/size;
        result[2] = numberOfZeros/size;

        for(int k = 0 ; k < 3 ; k++){
            System.out.println(result[k]);
        }
 }

 /* --------------------------------------------------------------- */

 // Complete the staircase function below.
 
 static void staircase(int n) {

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                if((i+j) > n){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
}

/* ------------------------------------------------------------------*/


/* Complete the miniMaxSum function below. 

input : 1 2 3 4 5
output : 10 14

explanation: 

Our initial numbers are 1,2 3,4 5 . We can calculate the following sums using four of the five integers:

If we sum everything except 1 , our sum is 2+3+4+5 =  .
If we sum everything except 2, our sum is 1+3+4+5 = .
If we sum everything except 3, our sum is 1+2+4+5 = .
If we sum everything except 4, our sum is 1+2+3+5 = .
If we sum everything except 5, our sum is 1+2+3+4= .

*/

static void miniMaxSum(int[] arr) {
        
        int size = arr.length;
        long [] result = new long [size];
        long sum = 0;
        int j = 0;

        while( j < size ){
            for( int i = 0 ; i < size ; i++ ){
                if(i == j){
                    continue;
                 }
                sum += arr[i];
        }
            result[j] = sum;
            sum = 0;
            j++;
        }

        long min = getMin(result);
        long max = getMax(result);
        
         System.out.println(min + " " + max);


}

static long getMin(long[]arr){
         long min = arr[0];
         
         for( int k = 0 ; k < arr.length ; k++){
            if(arr[k] < min){
                min = arr[k];
            }
        }
         
         return min;
}
     
static long getMax(long[]arr){
        long max = arr[0];
         
        for( int k = 0 ; k < arr.length ; k++){
            if(arr[k] > max){
                max = arr[k];
            }
        }
         
         return max;
}

/* ------------------------------------------------------------*/

 /* Complete the birthdayCakeCandles function below. 

For example, if your niece is turning 4 years old, and the cake will have 4 candles 
of height 4,4,1,3 she will be able to blow out  candles successfully
, since the tallest candles are of height 3 and there are 2 such candles.

 */

static int birthdayCakeCandles(int[] ar) {

        int count = 0;
        int max_height = ar[0];

        for( int i = 0 ; i < ar.length ; i++ ){
            if(ar[i] > max_height){
                max_height = ar[i];
            }
        }

        for(int j = 0 ; j < ar.length ; j++){
            if(ar[j] == max_height){
                count++;
            }
        }

        return count;
}

/* -------------------------------------------------------------------- */

/*
     * Complete the timeConversion function below.
     */
static String timeConversion(String s) {
        
        /* hours = time[0]
           minutes = time[1]
           seconds = time[2]
           AM_PM = time[3] */
        
        String [] time = s.split(":");

        String result = "";

        if( "12".equals(time[0]) && "00".equals(time[1]) && "00AM".equals(time[2])){
            result = "00" + ":" + "00" + ":" + "00";           //00:00:00
        }else if( "12".equals(time[0]) && "00".equals(time[1]) && "00PM".equals(time[2])){
            result = "12" + ":" + "00" + ":" + "00";
        }else if("12".equals(time[0]) && "PM".equals(time[2].substring(2))){
            result = "12" + ":" + time[1] + ":" + time[2].substring(0,2);
        }else if("12".equals(time[0]) && "AM".equals(time[2].substring(2))){
            result = "00" + ":" + time[1] + ":" + time[2].substring(0,2);
        }else if(!("12".equals(time[0])) && "AM".equals(time[2].substring(2)) ){
            result = time[0]+ ":" + time[1] + ":" + time[2].substring(0,2);
        }else{
            int hours = Integer.parseInt(time[0]) + 12 ;
            time[0] = Integer.toString(hours);
            result = time[0]+ ":" + time[1] + ":" + time[2].substring(0,2);
        }

        return result;
}

/* -----------------------------------------------------------------------------*/

/* Complete the gradingStudents function below.

HackerLand University has the following grading policy:

Every student receives a grade  in the inclusive range from 0  to 100 .
Any grade less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's grade  according to these rules:

If the difference between the grade and the next multiple of 5 is less than 3 , round  up to the next multiple of 5 .
If the value of grade is less than 38 , no rounding occurs as the result will still be a failing grade.

*/
static int[] gradingStudents(int[] grades) {
       
       int size = grades.length;
       int[]finalGrades = new int[size];

       for(int i = 0 ; i < size ; i++){
           if(grades[i] < 38){
               finalGrades[i] = grades[i];
           }else{
               if(grades[i] % 5 == 0){
                   finalGrades[i] = grades[i];
               }else{
                   int multibleOf5 = grades[i];
                   while(multibleOf5 % 5 != 0){
                       multibleOf5++;
                   }
                   int newGrade = multibleOf5 - grades[i];

                   if(newGrade < 3 ){
                       finalGrades[i] = multibleOf5;
                   }else if(newGrade >= 3){
                       finalGrades[i] = grades[i];

                   }

               }
               
           }
       }

       return finalGrades;
}


/* --------------------------------------------------------------------------- */

// Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int m = apples.length;
        int n = oranges.length;
        int apples_count = 0;
        int oranges_count = 0;
        int [] applesDistances = new int [m];
        int [] orangesDistances = new int [n];

        for(int i = 0 ; i < m ; i++){
            applesDistances[i] = apples[i]+a;
            if(applesDistances[i] >= s && applesDistances[i] <= t){
                apples_count++;
            }
        }

        for(int j = 0 ; j < n ; j++){
            orangesDistances[j] = oranges[j]+b;
            if(orangesDistances[j] >= s && orangesDistances[j] <= t){
                oranges_count++;
            }
        }

        System.out.println(apples_count);
        System.out.println(oranges_count);
    }


/* ------------------------------------------------------------- */

  // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        String result = "";

        if( (x2 > x1) && (v2 > v1)){
            result = "NO";
        }else{
            while(x2 > x1){
                x1 += v1;
                x2 +=v2;

                if(x1 == x2){
                    result = "YES";
                }else if( x1 > x2){
                    result = "NO";
                    break;
                }
            }
        }
        return result;
    }

/* -------------------------------------------------------------------------------*/

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int size = scores.length;
        int max = scores[0];
        int min = scores[0];
        int max_count = 0;
        int min_count = 0;
        int [] result = new int[2];

        for(int i = 0 ; i < size ; i++ ){
            if(scores[i] > max){
                max = scores[i];
                max_count++;
            }else{
                continue;
            }
        }

        for(int i = 0 ; i < size ; i++ ){
            if(scores[i] < min){
                min = scores[i];
                min_count++;
            }else{
                continue;
            }
        }

        result[0] = max_count;
        result[1] = min_count;

        return result;

    }

/* -------------------------------------------------------------------- */

// Complete the birthday function below. ( IMPORTANT )
    static int birthday(List<Integer> s, int d, int m) {
        
        int count = 0;
        int sum = 0;
        int size = s.size();

        //first way
        if(m <= size){
            for(int i = 0 ; i < m ; i++){
                sum += s.get(i);

            }

            if(sum == d){
                count++;
            }
        }

        for( int j = 0 ; j < size - m ; j++){   //(size - m) 3shan na already 7sabt 1 way fe l                                                      awel  
            sum = sum - s.get(j) + s.get(j+m);

            if( sum == d){
                count++;
            }

        }

        return count;
    }

/* ---------------------------------------------------------------*/

// Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {

        int count = 0;

        for( int i = 0 ; i < n ; i++){
            for( int j = i+1 ; j < n ; j++){
                if(((ar[i]+ar[j]) % k) == 0 ){
                        count++;
                    }
                }

            } 
        
        return count;

    }

/* -------------------------------------------------------------------------------- */
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        int size = arr.size();
        int count = 0 ;
        int [] types = new int[5];
        int result = 0;

            for( int i = 1 ; i <= 5 ; i++ ){
                for(int j = 0 ; j < size ; j++){
                        if(i == arr.get(j)){
                            count++;

                        }
                }
                types[i-1] = count;
                count = 0;
            }

            int max = getMax(types);

            for(int i = 0 ; i < 5 ; i++){
                if(max == types[i]){
                    result = i+1;
                    break;
                }
            }
        

        return result;
    }

    static int getMax(int[]arr){
        int max = 0;
        int size = arr.length;

        for(int i = 0 ; i < size ; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        return max;
    }

/* ----------------------------------------------------------------------- */

static String dayOfProgrammer(int year) {   /* Check */


        String result = "";
        
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            result = Integer.toString(256-244) + "." + "09" + "." + Integer.toString(year);
        }else{
            result = Integer.toString(256-243) + "." + "09"+ "." + Integer.toString(year);
        }

        return result;
    }

/* ----------------------------------------------------------------------------------------- */

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

         int itemAnnDidnotEat = bill.get(k) ;
         int sum = 0;

         for(int i = 0 ; i < bill.size() ; i++){
             if(itemAnnDidnotEat == bill.get(i)){
                 continue;
             }else{
                 sum += bill.get(i);
             }
         }


         if( b == sum/2){
             System.out.println("Bon Appetit");
        }else{
            System.out.println(itemAnnDidnotEat / 2);
        }

    }

/* ------------------------------------------------------------------------------- */

/*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int [] prices = new int [keyboards.length * drives.length];
        int k = 0;
        int result = 0;

        while( k < keyboards.length * drives.length ){
            for( int i = 0 ; i < keyboards.length ; i++ ){
                for( int j = 0 ; j < drives.length ; j++ ){
                    prices[k] = keyboards[i]+drives[j];
                    if(prices[k] > b){
                        prices[k] = 0 ;
                    }
                    k++;
                }
            }
        }

        int max = getMax(prices);

        if(max == 0){
            result = -1;
        }else{
            result = max;
        }

        return result;
        
    }


    static int getMax(int[]arr){
        int max = arr[0];

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }


        return max;
    }

/* ---------------------------------------------------------------------------------------- */

// Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {

        String result = "";
        int distanceBtnCatA_MouseC = Math.abs(z - x);
        int distanceBtnCatB_MouseC = Math.abs(z - y);

        if(distanceBtnCatA_MouseC < distanceBtnCatB_MouseC){
            result = "Cat A";

        }else if(distanceBtnCatB_MouseC < distanceBtnCatA_MouseC){
            result = "Cat B";

        }else{
            result = "Mouse C";
        }

        return result;

    }
/*-----------------------------------------------------------------------------------------*/

 // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {

        int size = height.length;
        int max = getMax(height);
        int result = 0;

        if( k > max){
            result = 0 ;
        }else{
            result = Math.abs(k - max);
        }

        return result;
    }

    static int getMax(int [] arr){
        int max = arr[0];
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

/* ----------------------------------------------------------------------------------- */

// Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        
        String letters = "abcdefghijklmnopqrstuvwxyz";
        List <Integer> a = new ArrayList<>();

        for( int i = 0 ; i < word.length() ; i++){
            int c = letters.indexOf(word.charAt(i));
            a.add(h[c]);
        }

        int max = getMax(a);
        int area = max * word.length();

        return area;


    }

    static int getMax(List<Integer>a){
        int max = a.get(0);

        for(int i = 0 ; i < a.size() ; i++){
            if(a.get(i) > max){
                max = a.get(i);
            }
        }

        return max;
    }

/* -------------------------------------------------------------------------------------- */

