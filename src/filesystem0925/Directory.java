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
public class Directory extends FileEntity {
    private Directory parent;
    private FileEntity[] dirList;
    private int itemCount;
    
    public Directory(String name) {
        super(name);
        this.dirList = new FileEntity[2];
        this.itemCount = 0;
    }

    public Directory(String name, Directory parent) {
        super(name);
        this.dirList = new FileEntity[2];
        this.itemCount = 0;
        this.parent = parent;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
   
    public Directory getParent()  {
        return this.parent;
    }
    
    public FileEntity[] getDirList()  {
        return this.dirList;
    }
    
    public FileEntity getDirListItem(int i)  {
        return this.dirList[i];
    }
    
    public int getItemCount()  {
        return this.itemCount;
    }
    
    
    public void addFile(String name) {
        if (itemCount >= dirList.length) {
            dirList = doubleArray(dirList);
        }
        dirList[itemCount++] = new File(name, this);
    }
    
    public void addDirectory(String name) {
        if (itemCount >= dirList.length) {
            dirList = doubleArray(dirList);
        }
        
        dirList[itemCount++] = new Directory(name, this);
    }
    
    
    public void search(String keyword) {
        
       if (this.itemCount == 0) {
           return;
       }
       
       for( int i =0 ; i<this.itemCount; i++) {
           if (this.getDirListItem(i).getName().contains(keyword)) {
               this.getDirListItem(i).printAddress();
               System.out.println();
           }
           
           if (this.getDirListItem(i) instanceof Directory) {
               ((Directory)this.getDirListItem(i)).search(keyword);
           }
       }
       
      
        
    }
    
    @Override
    public void printAddress() {
        Directory tmp =  this;
        String[] address = new String[2];
        int count = 0;
        
        address[count++] = tmp.getName();
        while (tmp.getParent() != null) { 
            if (count >= address.length) {
                address = doubleArray(address);
            }
            
            tmp = tmp.getParent();
            address[count++] = tmp.getName();     
        }
        
        
        for (int i = count - 1; i >= 0 ; i--) {
            if (address[i] != null) {
                System.out.print("\\" + address[i]);
            }  
        }
        
        
  
    }
    
    public void printDirList() {
       
        
        for (int i = 0; i < itemCount ; i++) {   
            System.out.println(dirList[i].getName()); 
        }
  
    }
    
    
    private String[] doubleArray(String[] arr) {
        String[] tmp = new String[arr.length * 2];
        
        for (int i =0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        
        return tmp;
    }
    
    private FileEntity[] doubleArray(FileEntity[] arr) {
        FileEntity[] tmp = new FileEntity[arr.length * 2];
        
        for (int i =0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        
        return tmp;
    }
    
    
}
