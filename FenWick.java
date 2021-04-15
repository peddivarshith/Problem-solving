class FenWick{
	//Time complexity for update and retriving the sum between two indexes is O(logn)
    public  long nums[];
    public Solution(int nums[]){
        int n=nums.length;
        this.nums=new long[n+1];
        for(int i=0;i<n;i++){
            int pos=i+1;
            int value=nums[i];
            while(pos<=n+1){
                this.nums[pos]+=value;
                pos=pos+Integer.lowestOneBit(pos);
            }
        }
    }
    public long sum(int s1,int s2){
        long get_lowest_sum_value=get_value(s1+1);
        long get_upper_sum_value=get_value(s2+1);
        return get_upper_sum_value-get_lowest_sum_value+ this.nums[s1+1];
    }
    private long get_value(int index){
        long sum=0;
        while(index>0){
            sum=sum+this.nums[index];
            index=index-Integer.lowestOneBit(index);
        }
        return sum;
    }
}