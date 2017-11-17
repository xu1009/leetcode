package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;

public class Test {
    @org.junit.Test
    public void justForTst() {
        String[] data = new String[]{"abc", "cba", "adc", "acd"};
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : data) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            ArrayList<String> tempList = (ArrayList<String>) map.get(String.valueOf(array));
            if (tempList == null)
                tempList = new ArrayList<>();
            tempList.add(str);
            map.put(String.valueOf(array), tempList);
            // map.put(String.valueOf(array),);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            ArrayList<String> tempList = (ArrayList<String>) map.get(String.valueOf(array));
            tempList.add(str);
            map.put(String.valueOf(array), tempList);
            // map.put(String.valueOf(array),);
        }

        return null;
    }

    @org.junit.Test
    public void tst1() {
        Map<String, Long> data = new HashMap<>();
        data.put("1", Long.valueOf(2));
        System.out.println(data.get("1"));
    }

    @org.junit.Test
    public void getProductOfTwoStr() {
        String str1 = "123";
        String str2 = "123";
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();
        int num1 = 0;
        int num2 = 0;
        if (str1.length() != 0 && str1 != null) {
            for (int i = 0; i < str1.length(); i++) {
                num1 += Math.pow(10, i) * (str1.charAt(i) - 0x30);
            }
        }
        if (str2.length() != 0 && str2 != null) {
            for (int i = 0; i < str2.length(); i++) {
                num2 += Math.pow(10, i) * (str2.charAt(i) - 0x30);
            }
        }
        // return num1 + num2;
    }

    @org.junit.Test
    public void bigNumMutil() {  // 分治,分开迭代
        String str1 = "12333";
        String str2 = "123123";


    }


    public String addBigNum(String num1, String num2) {
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int number1 = 0;
        int number2 = 0;
        int i = 0;
        int carry = 0;
        int temp = 0;
        String sum = "";
        while (i < num1.length() && i < num2.length()) {
            number1 = num1.charAt(i) - 0x30;
            number2 = num2.charAt(i) - 0x30;
            temp = number1 + number2 + carry;
            sum += (temp >= 10 ? temp - 10 : temp);
            carry = temp >= 10 ? 1 : 0;
            i += 1;
        }
        while (i < num1.length()) {
            temp = num1.charAt(i) - 0x30 + carry;
            sum += (temp >= 10 ? temp - 10 : temp);
            carry = temp >= 10 ? 1 : 0;
            i += 1;
        }
        while (i < num2.length()) {
            temp = num2.charAt(i) - 0x30 + carry;
            sum += (temp >= 10 ? temp - 10 : temp);
            carry = temp >= 10 ? 1 : 0;
            i += 1;
        }
        if (carry != 0)
            sum += "1";
        sum = new StringBuffer(sum).reverse().toString();
        return sum;
    }

    @org.junit.Test
    public void subsBigNum() {
        String num1 = "-2312313999";
        String num2 = "999";
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int number1 = 0;
        int number2 = 0;
        int i = 0;
        int carry = 0;
        int temp = 0;
        String sum = "";
        /**number1 negative**/
        while (i < num1.length() && i < num2.length()) {
            number1 = num1.charAt(i + 1) - 0x30;
            number2 = num2.charAt(i) - 0x30;
            temp = number2 - carry - number1;
            //temp = number1 + number2 + carry;
            //sum += (temp >= 10 ? temp - 10 : temp);
            carry = number2 >= number1 ? 0 : 1;
            i += 1;
        }
        while (i < num1.length()) {
            temp = num1.charAt(i) - 0x30 + carry;
            sum += (temp >= 10 ? temp - 10 : temp);
            carry = temp >= 10 ? 1 : 0;
            i += 1;
        }
        while (i < num2.length()) {
            temp = num2.charAt(i) - 0x30 + carry;
            sum += (temp >= 10 ? temp - 10 : temp);
            carry = temp >= 10 ? 1 : 0;
            i += 1;
        }
        if (carry != 0)
            sum += "1";
        sum = new StringBuffer(sum).reverse().toString();
        System.out.println(sum);

    }

    /**
     * get comCode from decial
     * @param str
     * @return
     */
    public String getComCode(String str) {
        if (str.charAt(0) == '0')
            return str;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(9);
            for (int i = 1; i < str.length(); i++) {
                int tempNum = 9 - (str.charAt(i) - '0');
                sb.append(tempNum);
            }
            String temp = addBigNum(sb.toString(), "1");
            return temp.substring(temp.length() - str.length(), temp.length());
        }
    }

    public String addTwoBigNum(String str1, String str2) {
        boolean str1Sign = false;
        boolean str2Sign = false;
        //   int maxLen = Math.max(str1.length(), str2.length()) + 1; // 多出一位保存进位,最高位是符号位
        if (str1.charAt(0) == '-') {
            str1 = str1.substring(1);
            str1Sign = true;
        }
        if (str2.charAt(0) == '-') {
            str2 = str2.substring(1);
            str2Sign = true;
        }
        int maxLen = Math.max(str1.length(), str2.length()) + 2;
        while (str1.length() < maxLen) {
            if (str1.length() == maxLen - 1 && str1Sign == true)
                str1 = "9" + str1;
            else
                str1 = "0" + str1;
        }
        while (str2.length() < maxLen) {
            if (str2.length() == maxLen - 1 && str2Sign == true)
                str2 = "9" + str2;
            else
                str2 = "0" + str2;
        }
        str1 = getComCode(str1);
        str2 = getComCode(str2);
        String result = addBigNum(str1, str2);
        result = result.substring(result.length() - str1.length(), result.length());
        result = getComCode(result);
        return result;
    }

    @org.junit.Test
    public void tstBigNum() {
        String str1 = "-100";
        String str2 = "-1";
        String result = addTwoBigNum(str1, str2);
        System.out.println(result);
    }



    public String multiTwoBigNum(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return "";
        if (str1 == null || str2 == null)
            return null;
        int[][] tempResult = new int[str2.length()][str2.length() + str1.length() - 1];
        int[] midResult = new int[str2.length() + str1.length() - 1];
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                tempResult[i][j + i] = (str2.charAt(i) - '0') * (str1.charAt(j) - '0');
            }
        }
        for (int col = 0; col < midResult.length; col++) {
            for (int row = 0; row < str2.length(); row++) {
                midResult[col] += tempResult[row][col];
            }
        }

        for (int k = midResult.length - 1; k > 0; k--) {
            midResult[k - 1] += midResult[k] / 10;
            midResult[k] = midResult[k] % 10;
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (midResult[index] == 0){
            index += 1;
            if (index == midResult.length)
                break;
        }
        if (index == midResult.length)
            return "0";
        else
            for (int begin = index; begin < midResult.length; begin++){
                result.append(midResult[begin]);
            }
        return result.toString();
    }

    @org.junit.Test
    public void Md5() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        Date date = new Date();
        String ts = String.valueOf(date.getTime());
        System.out.println(ts);
        String str = "bizwork" + ":" + "e61a4232183c372ff12d609b6ddb9b89" + ":" + ts;
        md.update(str.getBytes());
        System.out.println(new BigInteger(1, md.digest()).toString(16));
        HttpPost httpPost = new HttpPost("http://localhost:8585/tt");
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("name","888"));
        nameValuePairs.add(new BasicNameValuePair("info","账号"));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
        HttpResponse response = new DefaultHttpClient().execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        String jsonResult = EntityUtils.toString(httpEntity).toString();
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(jsonResult,Map.class);

        System.out.println(map.get("text"));
    }

    @org.junit.Test
    public void findTwiceNum(){
        int[] nums = new int[]{4,4};
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (i == nums.length){
                result.add(nums[nums.length]);
                continue;
            }
            if (nums[i] != nums[i + 1])
                continue;
            result.add(nums[i]);
            i += 1;
        }
        System.out.println("");
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;   //    0 =< index <= nums.lemgth - 1
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = 0 - nums[index];  // negative
        }
        return res;
    }


    @org.junit.Test
   public void deleteListNode(){
        int n = 1;
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
        ArrayList<ListNode> tempList = new ArrayList<>();
        while (listNode != null){
            tempList.add(new ListNode(listNode.val));
            listNode = listNode.next;
        }
        int len = tempList.size();
        if (n <= 0 || n > len)
            return;
        tempList.remove(len - n);
        for (int i = 0; i < tempList.size() - 1; i++){
            tempList.get(i).next = tempList.get(i + 1);
        }
        System.out.println(tempList.get(0));
   }

   public int coin(int targetNum, int[] array){
//       int[] array = new int[]{1,2,3,4};
//       int targetNum = 200;
       int[] tempResult = new int[targetNum + 1];
       Map<Integer, List<Integer>> detailRes = new HashMap<>();
       List<Integer> concreteNum = new ArrayList<>();
       for (int i = 0; i < tempResult.length; i++){
           tempResult[i] = i;
           concreteNum = new ArrayList<>();
           detailRes.put(i,concreteNum);
           for (int j = 0; j < array.length; j++){
               if (i >= array[j] && tempResult[i - array[j]] + 1 <= tempResult[i]){
                    tempResult[i] = tempResult[i - array[j]] + 1;
                    concreteNum.removeAll(concreteNum);
                    concreteNum.addAll(detailRes.get(i - array[j]));
                    concreteNum.add(array[j]);
               }
           }
       }
        System.out.println(tempResult[targetNum] + " " + detailRes.get(targetNum).toArray());
        return tempResult[targetNum];
   }
    @org.junit.Test
   public void getLeastSquarNum(){
       int target = 13;
       int len = (int) Math.sqrt(target);
       int[] array = new int[len];
       for (int i = 0; i < len; i++){
           array[i] = (int) Math.pow(i + 1, 2);
       }
       int leastNum = coin(target, array);
       System.out.println(leastNum);
   }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <=i; j++)
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
        }
        return dp[n];
    }

    /**
     * 功能没实现,push index
     */
    @org.junit.Test
    public void getLongestParentheses(){
       String data = "((()))())";
//       int totalNum = 0;
//       int num = 0;
       int longest = 0;
       Stack<Integer> temp = new Stack<>();
       for (int i = 0; i < data.length(); i++){
           char tempChar = data.charAt(i);
           if (tempChar == '(' || tempChar == '['){
               temp.push(i);
           }else if (tempChar == ']' || tempChar == ')'){
               if (temp.size() > 0 && temp.peek() != null && data.charAt(temp.peek()) == '(' && tempChar == ')' || temp.size() > 0 && temp.peek() != null && temp.peek() == '[' && tempChar == ']'){
//                    longest = Math.max(i - temp.pop() + 1, longest);
//                    totalNum += 2;
                   temp.pop();
               }else{
//                   num = Math.max(num,totalNum);
                   temp.push(i);
               }
           }
       }
       int a = data.length(); int b = 0;
       if (temp.size() == 0)
           longest = data.length();
       else
       while (!temp.isEmpty()){     // stack element asc order
           b = temp.peek();
           temp.pop();
           longest = Math.max(longest, a - b - 1);
           a = b;
       }
       System.out.println(longest);

       //return totalNum;
//       System.out.println(num);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public void getPartitionPalindrom(){
        String data = "aab";

    }

    @org.junit.Test
    public void getLongestSubPalindrom(){
        String str = "12112";
        Set<String> data = new HashSet<>();
        HashMap<Integer,Integer> index = new HashMap<>();
        char[] tempString = str.toCharArray();
        for (int i = 0; i < tempString.length; i++){
            lowIndex = i; maxNum = 1;
            getLongestPalindrom(tempString, i, i);
            getLongestPalindrom(tempString, i, i + 1);
            index.put(lowIndex, maxNum);
       //     lowIndex = 0; maxNum = 0;
            System.out.println("index: " + i + " low: " + lowIndex + " hi: " +  maxNum);
        }
        System.out.println(index.size() - 1);
        System.out.println(str.substring(lowIndex, lowIndex + maxNum));
    }

    private int maxNum = 0;
    private int lowIndex = 0;

    public void getLongestPalindrom(char[] str, int low, int hi){
        while (low >= 0 && hi < str.length && str[low] == str[hi]){
            lowIndex = maxNum > (hi - low + 1) ? lowIndex : low;
            maxNum = maxNum > (hi - low + 1) ? maxNum : (hi - low + 1);
            low -= 1;
            hi += 1;
        }
    }

    /**
     * 动态规划,还是和前面状态，找状态转移方程
     */
    @org.junit.Test
    public void tstMethod(){
        int a = 4; int b = 0; int longest = 0;
        Stack<Integer> data = new Stack<>();
        data.push(0);  // index from small to big
        data.push(1);
        while (!data.isEmpty()){
            b = data.peek();
            data.pop();
            longest = Math.max(longest, a - b - 1);
            a = b;
        }
        longest = Math.max(longest, a);
        System.out.println(longest);
    }



    @org.junit.Test
    public void lexicographcialSort(){
        int n = 23489;
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> temp = new TreeMap<>();
        for (int i = 1; i <= n; i++){
            temp.put(("" + i), i);
        }
        for (Map.Entry<String,Integer> ele : temp.entrySet()){
            res.add(ele.getValue());
        }

    }


    @org.junit.Test
    public void tst() throws UnsupportedEncodingException {
        String str = "呲牙";
//        byte[] bytes = str.getBytes("UTF-8");
        byte[] bytes = new byte[]{91,-27,-111,-78,-25,-119,-103,93};
        System.out.println(new String(bytes,"UTF-8"));
    }

    /**
     * 词典排序
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> res = new ArrayList<>();
//        for(int i=1;i<10;++i){
//            dfs(i, n, res);
//        }
//        return res;
//    }

    private int cur = 1;
    private int n = 100;
    private List<Integer> res = new ArrayList<>();


//    @org.junit.Test
//    public void dfs(int cur, int n, List<Integer> res){
//        if(cur>n)
//            return;
//        else{
//            res.add(cur);
//            for(int i=0;i<10;++i){
//                if(10*cur+i>n)
//                    return;
//                dfs(10*cur+i, n, res);
//            }
//        }
//    }

    /**
     * longest palindromic sequence
     * not continus
     */
    @org.junit.Test
    public void getLongestPalindromicSquence(){
        String str = "aaa";  //dynamic manager  two dimensional
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < str.length(); i++){
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--){
                if (str.charAt(i) == str.charAt(j)){
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                }
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        System.out.println(dp[0][str.length() - 1]);

    }

    @org.junit.Test
    public void getBuiltPalindromic(){
        String str = "";

    }


    @org.junit.Test
    public void getMaxNum(){
        int[] array = new int[500000];
        Random random = new Random();
        for (int i = 0; i < 500000; i++){

            array[i] = random.nextInt(100);
            if (array[i] == 0)
                array[i] = 1;

        }
        int sum = 0;
        int max = 0;
        int[] temp = new int[500000];
        int[] minNum = new int[500000];
        int min = Integer.MAX_VALUE;
        temp[0] = array[0] * array[0];
        min = array[0];
        max = temp[0];
        for (int i = 1; i < array.length; i++){
              if (min <= array[i]){
                  max = Math.max(((temp[i - 1] / min) + array[i]) * min, array[i] * array[i]);
                  min = max == array[i] * array[i] ? array[i] : min;
                  temp[i] = max;
              }else {     // 当前述比较小
                  max = Math.max(temp[i - 1], (temp[i - 1] / min + array[i]) * array[i]);
                  temp[i] = max == (temp[i - 1] / min + array[i]) * array[i] ? (temp[i - 1] / min + array[i]) * array[i] : array[i] * array[i];
                  min = array[i];
              }
        }

    }


    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

     This is case sensitive, for example "Aa" is not considered a palindrome here.

     Note:
     Assume the length of given string will not exceed 1,010.

     Example:

     Input:
     "abccccdd"

     Output:
     7

     Explanation:
     One longest palindrome that can be built is "dccaccd", whose length is 7.
     */
    @org.junit.Test
    public void longestPalindromeTransfer(){      // not necerssy care the how to transfer, only care the element of string
        String s = "bb";
        if (s == null || s.length() == 0)
            return;
        Set<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }
            else
                hs.add(s.charAt(i));
        }
//        return hs.isEmpty() ? count * 2 : count * 2 + 1;

    }

    /**
     * slow and fast pointer find the middle of palindromic
     * @param
     * @return
     */
    @org.junit.Test
    public void isPalindrom(){
        ListNode listNode = null;
        if (listNode == null)
            return;
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null){
            if (slow.val != listNode.val)
                return;
            slow = slow.next;
            listNode = listNode.next;
        }
        return;
    }

    public ListNode reverse(ListNode head) {  // get every element of ListNode, change its next to last element
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     For example,
     "A man, a plan, a canal: Panama" is a palindrome.
     "race a car" is not a palindrome.

     Note:
     Have you consider that the string might be empty? This is a good question to ask during an interview.

     For the purpose of this problem, we define empty string as valid palindrome.
     */
//    @org.junit.Test
//    public void validPalindrom(){
//        String str = "";
//        if (str == null)
//            return false;
//        if (str.length() == 0)
//            return true;
//        StringBuilder sb = new StringBuilder();
//        str = str.toLowerCase();
//        for (int i = 0; i < str.length(); i++){
//            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))
//                sb.append(str.charAt(i));
//        }
//        str = sb.toString();
//        if (str.length() == 0)
//            return true;
//        int len = str.length();
//        String str1 = str.substring((int) Math.ceil(len / 2));
//        str1 = new StringBuffer(str1).reverse().toString();
//        if (str.substring(0,str1.length()).equals(str1))
//            return true;
//        return false;
//
//    }

    @org.junit.Test
    public void largestPalindromicNum(){
        int len = 2;
        if (len <= 1)
            return;
        double minNum = Math.pow(10, len - 1);
        minNum = minNum * minNum;
        double maxNum = Math.pow(10, len) - 1;
        maxNum = maxNum * maxNum;
        for (double i = maxNum; i >= minNum; i--){
//            System.out.println(String.valueOf(i));
            String str1 = String.valueOf(i).split("\\.")[0];
            String str2 = new StringBuffer(str1).reverse().toString();
//            System.out.println(new StringBuffer(String.valueOf(i).split(".")[1]).reverse().toString());
            if (str1.equals(str2)){
                System.out.println(str1);
                break;
            }
        }
        return;
    }
    @org.junit.Test
    public void tstReverse(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode list = reverse(node);
        System.out.println();
    }

    @org.junit.Test
    public void spiltTest(){
       List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       Integer[] array = new Integer[list.size()];
       array = list.toArray(array);
       System.out.println(array);
    }
//    public static void main(String[] args) {
//        Test tst = new Test();
//        List<Integer> res = new ArrayList<>();
//        tst.dfs(1,100000, res);
//    }

    /**
     * Given a string, your task is to count how many palindromic substrings in this string.

     The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

     Example 1:
     Input: "abc"
     Output: 3
     Explanation: Three palindromic strings: "a", "b", "c".
     Example 2:
     Input: "aaa"
     Output: 6
     Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     Note:
     The input string length won't exceed 1000.
     */
    @org.junit.Test
    public void findAllProssiblePalindrom(){
        String str = "abc";
//        if (str.length() == 0 || str == null)
//            return 0;
        char[] strings = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < str.length(); i++){
            sum += getPalindrom(strings, i, i);
            sum += getPalindrom(strings, i, i+1);
        }
        System.out.println(sum);


    }


    public int getPalindrom(char[] str, int lo, int hi){
        int count = 0;
        while (lo >= 0 && hi < str.length && str[lo] == (str[hi])){
            count += 1;
            lo -= 1;
            hi += 1;
        }
        return count;
    }


    /**
     *Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */
    @org.junit.Test
    public void getMinCutPalindrom(){
        String s = "ababbbacbadas";
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i] = i;
        for (int i = 0; i < s.length(); i++){
            getMinPalindrom(s.toCharArray(), i, i, dp);  // self palindromic and then compare with dp[i-1]
            getMinPalindrom(s.toCharArray(), i, i + 1, dp);
        }
        System.out.println(dp[s.length() - 1]);
    }

    public void getMinPalindrom(char[] strs, int lo, int hi, int[]dp){
        while (lo >= 0 && hi < strs.length && strs[lo] == strs [hi]){
            if (lo == 0)
                dp[hi] = 0;
            else
                dp[hi] = Math.min(dp[lo - 1] + 1, dp[hi]);
            lo--;
            hi++;
        }
    }

    List<String> temp = new ArrayList<>();
    List<List<String>> resT = new ArrayList<>();
    public void backTrack(String strs, int l){
        if (temp.size() > 0 && l >= strs.length()){
            resT.add(temp);
        }

        for (int i = l; i < strs.length(); i++){
            if (isPalindrom(strs, l, i)){
                if (l == i)
                    temp.add(String.valueOf(strs.charAt(i)));
                else
                    temp.add(strs.substring(l, i));
                backTrack(strs, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public boolean isPalindrom(String strs, int lo, int hi){
        if (lo == hi)
            return true;
        while(lo < hi){
            if(strs.charAt(lo)!=strs.charAt(hi)) return false;
            lo++;hi--;
        }
        return true;
    }

    @org.junit.Test
    public void getAddedPalindrom(){
        String strs = "aacec";
        int end = 0;
        while (!isPalindrom(strs, 0, strs.length() - 1)){
            end = getMaxPalindrom(strs, 0);
            String add = strs.substring(end, strs.length());
            add = new StringBuffer(add).reverse().toString();
            strs = add + strs;
        }
        System.out.println(strs);
    }

    public int getMaxPalindrom(String strs, int end){
        int max = 0;
        while (end < strs.length()){
            if (isPalindrom(strs, 0, end)){
                max = Math.max(end + 1, max);
            }
            end += 1;
        }
        return max;
    }

    private int count;
    public void backTrackCount(int N, int pos, int[]used){
        if (pos > N){                // exit conditions
            count++;
            return;
        }
        for (int i = 1; i <= N; i++){
            if (used[i] == 0 && (pos % i == 0 || i % pos == 0)){
                used[i] = 1;       // enter and set status
                backTrackCount(N, pos + 1, used);
                used[i] = 0;      // exit and clear
            }
        }
    }

    /**
     *
     The gray code is a binary numeral system where two successive values differ in only one bit.

     Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

     For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

     00 - 0
     01 - 1
     11 - 3
     10 - 2
     Note:
     For a given n, a gray code sequence is not uniquely defined.

     For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

     For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */
    @org.junit.Test
    public void getGrayCode(){
        int n = 3;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        System.out.println();

    }

    @org.junit.Test
    public void getSubsets(){
        int[] array = new int[]{1,1,3};
        boolean[] used = new boolean[array.length];
        Arrays.sort(array);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, temp, array, 0);

//        backTrackingSubSets(result, temp, array, 0, used);
        System.out.println();
    }

    static private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    static void backTrackingSubSets(List<List<Integer>> res, List<Integer> temp, int[] nums, int start, boolean[] used){
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++){
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])continue;
            temp.add(nums[i]);
            used[i] = true;
            backTrackingSubSets(res, temp, nums, i + 1, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args){
        int[] array = new int[]{1,3,2};
        boolean[] used = new boolean[array.length];
        Arrays.sort(array);
        StringBuilder temp = new StringBuilder();
//        List<String> temp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        String strs = "25525511135";
        Test.backingTrackingIP(res, temp,0, strs);
        System.out.println();

//        Test.backTrackingPermutation(result, temp, 8, 3870);
//        Test.backtrack(result, temp, array, 0);
//        Test.getCombation(result, temp, 1, 3, 4);
//        Test.getPermutationNum(result, temp, array);
//        Test.backtrack1(result, temp, array, used);
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(array);
//        Test.backtrack(result, temp, array, 3, 0);
////        Test.findAllConisCompations();
//        char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        int row = 0;
//        int col = 0;
//        boolean[][] used1 = new boolean[3][4];
//        int index = 0;
//        backTracking(data, row, col, used1, "ABCCED", index);

//        System.out.println(result.get(result.size() - 1));

    }

    static private void getCombation(List<List<Integer>> result, List<Integer> temp, int index, int n, int k){
        if (temp.size() == k)
            result.add(new ArrayList<Integer>(temp));
        for (int i = index; i <= n; i++){
            temp.add(i);
            getCombation(result, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }

    public String getPermutation(int n, int k) {
        int pos = 0;

        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];

        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];   // index is num
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];   // mode  get next index
        }

        return String.valueOf(sb);


    }

    /**
     * NO DUPLICATE ELEMENTS
     * @param result
     * @param temp
     * @param nums
     */
    static  void getPermutationNum(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if (temp.size() == nums.length)
            result.add(new ArrayList<Integer>(temp));
        for (int i = 0; i < nums.length; i++){
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            getPermutationNum(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used) {
        if (tempList.size() == nums.length)
            list.add(new ArrayList<Integer>(tempList));
        for (int i = 0; i < nums.length; i++){
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack1(list, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }

    }

    @org.junit.Test
    public  void findAllConisCompations(){
        int n = 7;
        int[] conis = new int[]{2, 3, 6, 7};
        int[] result = new int[n + 1];
        List<List<Integer>> cos = new ArrayList<>();
        Map<Integer, List<Integer>> co = new HashMap<>();
        for (int i = 0; i <= n; i++){
            result[i] = i;
            co.put(i, new ArrayList<Integer>());
            for (int j = 0; j < conis.length; j++){
                if (i >= conis[j] && result[i - conis[j]] + 1 < result[i]){
                    result[i] = result[i - conis[j]] + 1;
                    List<Integer> temp = new ArrayList<>(co.get(i - conis[j]));
                    temp.add(conis[j]);
                    co.put(i, temp);
//                    result[i] = Math.min(result[i - conis[j]] + 1, result[i]);
                }
            }
        }
        System.out.println();
    }

    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){  // check every bit
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);  // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    static void getDFS(char[][] strs, String target){


    }

    static public boolean backTracking(char[][] boards, int row, int col, boolean[][] used, String target, int index){
        if (index == target.length())
            return true;
        if (row < 0 || row >= boards.length || col < 0 || col > boards[0].length || target.charAt(index) != boards[row][col] || used[row][col])
            return false;
        used[row][col] = true;

        if (  backTracking(boards, row - 1, col, used, target, index + 1) ||
              backTracking(boards, row + 1, col, used, target, index + 1) ||
              backTracking(boards, row, col + 1, used, target, index + 1) ||
              backTracking(boards, row, col - 1, used, target, index + 1))
            return true;

        used[row][col] = false;
        return false;
    }

    static public void getCombinations(){
        Map<String,String> digtialAndStr = new HashMap<>();
        String input = "23";


    }

    static  String backtracking2(String digs, int index, Map digAndStrs, StringBuilder sb, List res){
        if (sb.length() == digs.length() || index >= digs.length())
            res.add(sb.toString());
        String strs = (String) digAndStrs.get(digs.charAt(index));
        for (int i = 0; i < strs.length(); i++){
            sb.append(strs.charAt(i));
            backtracking2(digs, index + 1, digAndStrs, sb, res);  // index + 1 params can keep pre status when exit
            sb.deleteCharAt(sb.length() - 1);
        }


        return null;
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')]; // get strs by num
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);  // exit and keep the previous status
        }

    }

    public static void getCombination(String tempStr, String digits, int index, List<String> res){
        if (index >= digits.length()){
            res.add(tempStr);
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (int i = 0; i < digits.length(); i++){
            getCombination(tempStr + letters.charAt(i), digits, index + 1, res); // 状态在入口参数
        }
    }

    public static void combinationSum(List<List<Integer>> res, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0)return;
        else if (remain == 0) res.add(new ArrayList<>(tempList)); //
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                combinationSum(res, tempList, nums, remain - nums[i], i); // from small begin
                tempList.remove(tempList.size() - 1);
            }
        }
    }



    public static void getCombinations2(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int index, boolean[] used){
        if (remain < 0)return;
        else if (remain == 0) res.add(new ArrayList<Integer>(temp));
        else
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && used[i - 1] == used[i] && !used[i - 1])continue;
            temp.add(nums[i]);
            used[i] = true;
            getCombinations2(res, temp, nums, remain - nums[i], i + 1, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    @org.junit.Test
    public void tst12(){
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        boolean[] used = new boolean[nums.length];
        int target = 8;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getCombinations2(res, new ArrayList<Integer>(), nums, target, 0, used);
        System.out.println();
    }
    @org.junit.Test
    public void getParthess(){
        int n = 3;
        List<String> list = new ArrayList<String>();
        Test.backtrack123(list, "", 0, 0, 3);

    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack123(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack123(List<String> list, String str, int open, int close, int max){

        if(str.length() == max * 2){
            list.add(str);
            System.out.println(str);
            return;
        }
        if(open < max)   // left and right ,just like
            backtrack123(list, str + "(", open+1, close, max);  // exit  and back to this tracking
        if(close < open)
            backtrack123(list, str + ")", open, close+1, max);  // two backtracking so it is deep
    }


    public void backtracingParthensis(List<String> res, String temp, int left, int right, int n){
        if (temp.length() == n * 2){
            res.add(temp);
            return;
        }
        if (left < n)
            backtracingParthensis(res, temp + "(", left + 1, right, n);
        if (right < left)
            backtracingParthensis(res, temp + ")", left, right + 1, n);
    }
    String[] strs = {"1", "2", "3"};

    public static void backTrackingPermutation(List<String> res, StringBuilder temp, int n, int k){
        if (temp.length() == n){
            res.add(temp.toString());
            return;
        }
        for (int i = 1; i <= n; i++){
            if (temp.indexOf("" + i) != -1)continue;
            if (res.size() == k) return;
            temp.append(i);
            backTrackingPermutation(res, temp, n, k);
//            temp.remove(temp.size() - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void backingTrackingIP(List<String> res, StringBuilder sb, int start, String strs){
        if (sb.length() == 4 && start >= strs.length()){
            res.add(sb.toString().substring(0, sb.toString().length() - 1));
            return;
        }
        if (start >= strs.length() || (sb.length() == 4 && start < strs.length()))return;
        for (int i = 0; i < 3; i++){
            if ((start + i + 1) > strs.length())continue;
            if (Integer.valueOf(strs.substring(start, start + i + 1)) > 255)continue;
//            sb.add(strs.substring(start, start + i + 1));
            sb.append(strs.substring(start, start + i + 1) + ".");
            backingTrackingIP(res, sb, start + i + 1, strs);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void serachStrs(){
        String patterns = "b";
        boolean res = Pattern.matches(patterns, "b,");
        System.out.println(res);
    }
}