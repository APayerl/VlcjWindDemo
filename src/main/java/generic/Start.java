/*
This file is part of VlcjWindDemo.

VlcjWindDemo shows how to use the library VlcjWind
Copyright (C) 2017  Anders Payerl

VlcjWindDemo is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

VlcjWindDemo is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with VlcjWindDemo.  If not, see <http://www.gnu.org/licenses/>.

For contact use email anders{dot}payerl{at}gmail{dot}com
*/

package generic;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFileChooser;

import se.payerl.vlcjwind.VlcjWind;
import se.payerl.vlcjwind.VlcDetectionListener;

public class Start implements VlcDetectionListener {
	public Start() {
		int width = 0;
		int height = 0;
		int tmpW;
		int tmpH;
		for(GraphicsDevice gd: GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
			if(gd.getType() == GraphicsDevice.TYPE_RASTER_SCREEN) {
				tmpH = gd.getDisplayMode().getHeight();
				tmpW = gd.getDisplayMode().getWidth();
				if(tmpW*tmpH > width*height) {
					width = tmpW;
					height = tmpH;
				}
			}
		}

		VlcjWind vw = new VlcjWind(this);
		//vw.getMediaPlayer().prepareMedia("Z:\\Serier\\Boy Meets World\\Season 1\\Boy Meets World - 101 - Pilot.avi");
		vw.getMediaPlayer().prepareMedia(getVideoFilePath());
		for(int i = 0; i < 5; i++) {
			new gui.MyFrame(vw);
		}
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
	public String getVideoFilePath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(null);
	    chooser.setDialogTitle("Select video file");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
	    	return chooser.getSelectedFile().toString();
	    } else {
	    	return null;
	    }
	}

	@Override
	public String getVlcPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(null);
	    chooser.setDialogTitle("Select vlc folder");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
	    	return chooser.getSelectedFile().toString();
	    } else {
	    	return null;
	    }
	}
}