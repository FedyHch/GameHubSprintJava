/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import gamehub.controller.ListData;
import gamehub.service.Chaine;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Fakher_Pc
 */
public class ChannelView {
    private ListData ld=new ListData();
    public void View(){
         JFrame f= new JFrame();
        f.setLocation(100,100);
        f.setSize(1000,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        Canvas c =new Canvas();
        c.setBackground(Color.black);
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        p.add(c);
        f.add(p);
        
        
      NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:/Program Files/VideoLAN/VLC");
      Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
      
        MediaPlayerFactory mpf = new MediaPlayerFactory();
        
        EmbeddedMediaPlayer emp= mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
        
        emp.toggleFullScreen();
        
        emp.setEnableKeyInputHandling(false);
        emp.setEnableMouseInputHandling(false);
        Chaine ch= new Chaine();
        ch=ld.getChaines().get(0);
        
        
        String file=ch.geturl_chaine();
        
        emp.prepareMedia(file);
        
        emp.play();
        
                
        
        
    }    
    }
    

