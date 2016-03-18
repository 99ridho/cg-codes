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
        //glOrtho(0, 800, 0, 600, -1, 1);
        glOrtho(-200, 200, -150, 150, -1, 1);
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
        
        // titik pusat
        glPointSize(6);
        glBegin(GL_POINTS);
            glColor3f(0.0f, 0.0f, 0.0f);
            glVertex2f(0, 0);
        glEnd();
        
        // gambar kaki kincir angin
        glPushMatrix();
            glTranslatef(-60, -60, 0);
            glScalef(0.5f, 0.5f, 0);
            glBegin(GL_TRIANGLES);
                glColor3f(1.0f, 0.56f, 0.0f);
                glVertex2f(-20, -10);
                glColor3f(0.0f, 0.0f, 1.0f);
                glVertex2f(100, -10);
                glColor3f(0.0f, 1.0f, 0.0f);
                glVertex2f(45, 200);
            glEnd();
        glPopMatrix();
        
        glPushMatrix();
            glTranslatef(-78, -75, 0);
            glRotatef(animStep+=0.1f, 0.0f, 0.0f, 1.0f);
            glPushMatrix();
                //glTranslatef(350, 180, 0);
                glScalef(3.0f, 5.0f, 0);
                glBegin(GL_QUADS);
                    glColor3f(1.0f, 0.0f, 0.0f);
                    glVertex2f(12, 12);
                    glVertex2f(15, 12);
                    glVertex2f(15, 27);
                    glVertex2f(12, 27);
                glEnd();
            glPopMatrix();

            glPushMatrix();
                //glTranslatef(350, 180, 0);
                glTranslatef(-3, 28, 0);
                glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                glScalef(3.0f, 5.0f, 0);
                glTranslatef(3, -28, 0);
                glBegin(GL_QUADS);
                    glColor3f(1.0f, 0.5f, 0.0f);
                    glVertex2f(20, 12);
                    glVertex2f(23, 12);
                    glVertex2f(23, 27);
                    glVertex2f(20, 27);
                glEnd();
            glPopMatrix();
        glPopMatrix();
        
    }

    public static void main(String[] args) {
        WindmillObject w = new WindmillObject();
        w.start();
    }

}
