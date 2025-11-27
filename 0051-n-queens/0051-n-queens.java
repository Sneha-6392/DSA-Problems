class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int board[][]= new int[n][n];
        helper(0,board,n,res);
        return res;
    }
     public static void helper(int col,int [][] board,int n,List<List<String>> res ){
        if(col==n){
            res.add(generate_arraylist(board,n));
            return ;
        }
        for(int row=0;row<n;row++){
            if(isSafe(board,row,col,n)){
                board[row][col]=1;
                helper(col+1,board,n,res);
                board[row][col]=0;
            }
        }       
    }


        public static List<String> generate_arraylist(int[][] board,int n){
        List<String> l = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    s+='Q';
                }
                else{
                    s+='.';
                }
            }
            l.add(s);
        }
        return l;
        
    }


    public static boolean isSafe(int[][] board, int row,int col,int n){
        
        //uppper digonal
        int r=row;
        int c=col;
        while(r>=0&&c>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c--;
        }
        
        //bagal wali row
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]==1){
                return false;
            }
            c--;
        }
        
        //uppper digonal
        r=row;
        c=col;
        while(r<n&&c>=0){
            if(board[r][c]==1){
                return false;
            }
            r++;
            c--;
        }
        return true;
    }

}

    





















    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
