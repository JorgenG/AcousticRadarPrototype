/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.legounit;

import lejos.nxt.Sound;

/**
 *
 * @author JorgenG
 */
public class Alarm extends Thread {
    
    private int single;
    private int half;
    
    public void run() {
        Sound.setVolume(100);        
        Sound.playNote(Sound.PIANO, 739, 200);
        Sound.playNote(Sound.PIANO, 830, 200);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 200);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 554, 200);
        Sound.playNote(Sound.PIANO, 587, 200);
        /*
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 622, 200);
        Sound.playNote(Sound.PIANO, 739, 200);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 200);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 554, 200);
        Sound.playNote(Sound.PIANO, 739, 200);
        Sound.playNote(Sound.PIANO, 830, 200);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 200);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 554, 200);
        Sound.playNote(Sound.PIANO, 587, 200);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 622, 200);
        Sound.playNote(Sound.PIANO, 739, 200);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 200);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 587, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 830, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 659, 100);
        Sound.playNote(Sound.PIANO, 739, 100);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 493, 200);
        Sound.playNote(Sound.PIANO, 369, 100);
        Sound.playNote(Sound.PIANO, 415, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 415, 100);
        Sound.playNote(Sound.PIANO, 659, 100);
        Sound.playNote(Sound.PIANO, 622, 100);
        Sound.playNote(Sound.PIANO, 554, 100);
        Sound.playNote(Sound.PIANO, 493, 100);
        Sound.playNote(Sound.PIANO, 311, 100);
        Sound.playNote(Sound.PIANO, 329, 100);
        Sound.playNote(Sound.PIANO, 349, 100);
        Sound.playNote(Sound.PIANO, 369, 100);
        Sound.playNote(Sound.PIANO, 493, 200);
                */
    }
    
}
