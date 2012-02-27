package org.grondal.acousticradar.legounit;

/**
 * SoundListener is responsible for detecting sound and take appropriate
 * action. This thread is only active when the Lego Unit is in 
 * a low battery state or sound-activated mode. 
 * 
 * When a sound is detected it will notify the Mapper and the Mapper
 * will rotate one round whilst mapping the environments. 
 * 
 * @author JorgenG
 */
public class SoundListener extends Thread {
    
}
