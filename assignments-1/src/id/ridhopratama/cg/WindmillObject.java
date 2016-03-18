package id.ridhopratama.cg;

import org.lwjgl.opengl.*;
import org.lwjgl.LWJGLException;
import static org.lwjgl.opengl.GL11.*;

public class WindmillObject {

    private float animStep = 1.0f;
    private float currAngle = 0.0f;
    
    private void start() {
        try {
            Display.setTitle("Windmill");
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        while (!Display.isCloseRequested()) {
            // Clear the screen and depth buffer
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // warna screen setelah diclear
            glClearColor(255.0f, 255.0f, 255.0f, 1);

            // draw components
            draw();

            Display.update();
        }

        Display.destroy();
    }

    private void draw() {
        
        // gambar kaki kincir angin
        glPushMatrix();
            glTranslatef(300, 20, 0);
            glScalef(1.5f, 1.5f, 0);
            glBegin(GL_TRIANGLES);
                glColor3f(1.0f, 0.56f, 0.0f);
                glVertex2f(5, 30);
                glColor3f(0.0f, 0.0f, 1.0f);
                glVertex2f(85, 30);
                glColor3f(0.0f, 1.0f, 0.0f);
                glVertex2f(45, 200);
            glEnd();
        glPopMatrix();
        
        //glPushMatrix();
            glPushMatrix();
                glTranslatef(-120, -60, -0);
                glPushMatrix();
                    glTranslatef(350, 180, 0);
                    glBegin(GL_QUADS);
                        glColor3f(1.0f, 0.0f, 0.0f);
                        glVertex2f(120, 120);
                        glVertex2f(150, 120);
                        glVertex2f(150, 275);
                        glVertex2f(120, 275);
                    glEnd();
                glPopMatrix();

                glPushMatrix();
                    glTranslatef(285, 515, 0);
                    glRotatef(-90, 0.0f, 0.0f, 1.0f);
                    glBegin(GL_QUADS);
                        glColor3f(1.0f, 0.5f, 0.0f);
                        glVertex2f(120, 120);
                        glVertex2f(150, 120);
                        glVertex2f(150, 275);
                        glVertex2f(120, 275);
                    glEnd();
                glPopMatrix();
            glPopMatrix();
        //glPopMatrix();
        
        
    }

    public static void main(String[] args) {
        WindmillObject w = new WindmillObject();
        w.start();
    }

}
