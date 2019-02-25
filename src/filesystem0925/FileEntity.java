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
public abstract class FileEntity {
    protected String name;
    
    public FileEntity(String name){
        this.name = name;
    }
    
    public abstract String getName();
    public abstract void printAddress();
}
