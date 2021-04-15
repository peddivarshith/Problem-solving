import java.util.*;

class segmenttreefortimeslots {
    
    //segemnt tree node class
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int val;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            val = 0;
        }
    }
    
    SegmentTreeNode root;
    
    // Method to return the maximum programs can attend
    public int maxPrograms(int[][] programs) {
        int start=Integer.MAX_VALUE,end;
        Arrays.sort(programs,(x,y)->{
            if(x[1]==y[1]){
                return x[0]-y[0];
            }
            else{
                return x[1]-y[1];
            }
        });
        end=Integer.MIN_VALUE;
        for(int i=0;i<programs.length;i++){
            start=Math.min(start,programs[i][0]);
            end=Math.max(end,programs[i][1]);
        }
        int count=0;
        root=buildSegmentTree(start,end);
        for(int i=0;i<programs.length;i++){
            int get_present_node_value=query(root,programs[i][0],programs[i][1]);
            if(get_present_node_value!=1){
                count++;
                update(root,get_present_node_value);
            }
        }
        return count;
    }
    
    // Method to build segment tree
    private SegmentTreeNode buildSegmentTree(int start, int end) {
        if(start==end)
            return new SegmentTreeNode(start,end);
        int mid=(start+end)/2;
        SegmentTreeNode s=new SegmentTreeNode(start,end);
        s.left=buildSegmentTree(start,mid);
        s.right=buildSegmentTree(mid+1,end);
        return s;
    }

    //method to perform update segment tree    
    private void update(SegmentTreeNode curr, int lastDay) {
        if(curr.start==curr.end){
            curr.val=1;
            return;
        }
        
        int mid= (curr.start+curr.end)/2;
        if(mid>=lastDay){
            update(curr.left,lastDay);
            
        }
        else
            update(curr.right,lastDay);
            
        curr.val=Math.min(curr.left.val,curr.right.val);
    }
    
    // Method to perform Query
    private int query(SegmentTreeNode curr, int left, int right) {
        if(curr.start==left && curr.end==right){
            return curr.val;
        }
        
        int mid=(curr.start+curr.end)/2;
        if(mid>=right)
            return query(curr.left,left,right);
        
        else if(mid<left)
            return query(curr.right,left,right);
            
        else
        
            return (query(curr.left,left,mid)+query(curr.right,mid+1,right))>0?1:0;
        
        
        
    }  
    
    
}