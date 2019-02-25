/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem0925;

/**
 *
 * @author wingyiu
 */
public class File extends FileEntity {
    private Directory parent;
    
    public File(String name, Directory parent) {
        super(name);
        this.parent = parent;
        
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public Directory getParent()  {
        return this.parent;
    }

    
     private String[] doubleArray(String[] arr) {
        String[] tmp = new String[arr.length * 2];
        
        for (int i =0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        
        return tmp;
    }
    
   

    @Override
    public void printAddress() {
        Directory tmp =  this.getParent();
        String[] address = new String[2];
        int count = 0;
        
        address[count++] = this.getName();
        
        
        while (tmp != null) { 
            if (count >= address.length) {
                address = doubleArray(address);
            }
            address[count++] = tmp.getName();
            tmp = tmp.getParent();     
        }
        
        
        for (int i = count - 1; i >= 0 ; i--) {
            if (address[i] != null) {
                System.out.print("\\" + address[i]);
            }  
        }
      
    }
    
}
