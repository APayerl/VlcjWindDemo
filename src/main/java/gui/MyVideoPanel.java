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

package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import se.payerl.vlcjwind.FrameListener;

@SuppressWarnings("serial")
public class MyVideoPanel extends JPanel implements FrameListener {
	private BufferedImage image;
	public void newFrameRecieved(BufferedImage image) {
		this.image = image;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}