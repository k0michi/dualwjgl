package com.koyomiji.lwjgl2w3.verify.demo;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.nio.ByteBuffer;

/**
 * An LWJGL 2 program, compiled against LWJGL 2.9.3 only: opens a window and spins a triangle until the window is
 * closed, or for the number of frames given as the first argument, printing mouse clicks.
 */
public final class DisplayDemo {

	public static void main(String[] args) throws LWJGLException {
		int frames = args.length > 0 ? Integer.parseInt(args[0]) : -1;
		System.out.println("Desktop mode: " + Display.getDesktopDisplayMode());
		System.out.println("Fullscreen modes: " + Display.getAvailableDisplayModes().length);

		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.setTitle("lwjgl2w3 Display demo");
		Display.setResizable(true);
		Display.setVSyncEnabled(true);
		Display.create();
		System.out.println("Created " + Display.getWidth() + "x" + Display.getHeight() + ", OpenGL "
			+ GL11.glGetString(GL11.GL_VERSION) + " (" + GL11.glGetString(GL11.GL_RENDERER) + ")");

		long start = Sys.getTime();
		int frame = 0;
		while (!Display.isCloseRequested() && frame != frames) {
			while (Mouse.next()) {
				if (Mouse.getEventButton() >= 0) {
					System.out.println(Mouse.getButtonName(Mouse.getEventButton()) + (Mouse.getEventButtonState() ? " down" : " up")
						+ " at " + Mouse.getEventX() + ", " + Mouse.getEventY());
				}
			}
			if (Display.wasResized()) {
				System.out.println("Resized to " + Display.getWidth() + "x" + Display.getHeight());
			}
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
			GL11.glClearColor(0.1f, 0.1f, 0.15f, 1f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

			GL11.glLoadIdentity();
			GL11.glRotatef((Sys.getTime() - start) * 0.1f, 0f, 0f, 1f);
			GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glColor3f(1f, 0f, 0f);
			GL11.glVertex2f(0f, 0.6f);
			GL11.glColor3f(0f, 1f, 0f);
			GL11.glVertex2f(-0.5f, -0.4f);
			GL11.glColor3f(0f, 0f, 1f);
			GL11.glVertex2f(0.5f, -0.4f);
			GL11.glEnd();
			if (frame == 10) {
				// the triangle covers the centre: not the clear colour there
				ByteBuffer pixel = BufferUtils.createByteBuffer(4);
				GL11.glReadPixels(Display.getWidth() / 2, Display.getHeight() / 2, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
				System.out.println("Centre pixel: " + (pixel.get(0) & 0xFF) + ", " + (pixel.get(1) & 0xFF) + ", " + (pixel.get(2) & 0xFF));
			}

			Display.update();
			Display.sync(60);
			frame++;
		}
		System.out.println("Rendered " + frame + " frames in " + (Sys.getTime() - start) + " ms");
		Display.destroy();
	}

}
