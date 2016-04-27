public class Solution {
    static String[] twenty = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
    static String[] ten = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String thousand(int n) {
        String ans="";
        if(n==0) return ans;
        if(n%100<=20) ans = twenty[n%100];
        else ans = n%10==0 ? ten[n/10%10] : ten[n/10%10]+" "+twenty[n%10];
        if(n<100) return ans;
        if(ans.length()!=0) ans = " "+ans;
        return twenty[n/100%10]+" Hundred"+ans;
    }
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String ans = thousand(num%1000);
        if(num<1000) return ans;
        if(num%1000>0) ans = " "+ans;
        ans = num/1000%1000==0 ? ans : thousand(num/1000%1000)+" Thousand"+ans;
        if(num<1000000) return ans;
        if(num/1000%1000>0) ans = " "+ans;
        ans = num/1000000%1000==0 ? ans : thousand(num/1000000%1000)+" Million"+ans;
        if(num<1000000000) return ans;
        if(num/1000000%1000>0) ans = " "+ans;
        return numberToWords(num/1000000000)+" Billion"+ans;
    }
}
