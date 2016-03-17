package id.ridhopratama.cg;

import org.lwjgl.opengl.*;
import org.lwjgl.LWJGLException;
import static org.lwjgl.opengl.GL11.*;

// Soal 1A, 1B, 1C
public class PrimitiveObject {

    private void start() {
        try {
            Display.setTitle(":3");
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, 1, -1);
        glMatrixMode(GL_MODELVIEW);

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
        
        // gambar rumah
        glPushMatrix();
            glTranslatef(-100, 100, 0);
            
            // gambar segi 4
            glPushMatrix();
                glTranslatef(120, 100, 0);
                glBegin(GL_QUADS);
                    glColor3f(0.44f, 0.188f, 0.627f);
                    glVertex2f(120, 100);
                    glVertex2f(100 + 185, 100);
                    glVertex2f(100 + 185, 100 + 100);
                    glVertex2f(120, 100 + 100);
                glEnd();
            glPopMatrix();

            //gambar cerobong asap
            glPushMatrix();
                glTranslatef(250, 180, 0);
                glBegin(GL_QUADS);
                    glColor3f(0.5f, 0.5f, 0.5f);
                    glVertex2f(120, 120);
                    glVertex2f(150, 120);
                    glVertex2f(150, 200);
                    glVertex2f(120, 200);
                glEnd();
            glPopMatrix();

            // gambar segitiga buat atap
            glPushMatrix();
                glTranslatef(225, 250, 0);
                glBegin(GL_TRIANGLES);
                    glColor3f(0.6f, 0.4f, 0.2f);
                    glVertex2f(-10, 50);
                    glVertex2f(205, 50);
                    glVertex2f(100, 135);
                glEnd();  
            glPopMatrix();

            // gambar pintu
            glPushMatrix();
                glTranslatef(210, 100, 0);
                glBegin(GL_QUADS);
                    glColor3f(0.0f, 0.0f, 0.0f);
                    glVertex2f(100, 100);
                    glVertex2f(130, 100);
                    glVertex2f(130, 130);
                    glVertex2f(100, 130);
                glEnd();
            glPopMatrix();
        glPopMatrix();
        
        // gambar kotak bolong
        glPushMatrix();
            glTranslatef(450, 250, 0);
            glBegin(GL_QUADS);
                glColor3f(1.0f, 1.0f, 1.0f);
                glVertex2f(100, 100);
                glVertex2f(200, 100);
                glVertex2f(200, 200);
                glVertex2f(100, 200);
            glEnd();
            
            glLineWidth(2.0f);
            glBegin(GL_LINE_STRIP);
                glColor3f(0.9f, 0.73f, 0.52f);
                glVertex2f(100, 100);
                glVertex2f(200, 100);
                glVertex2f(200, 200);
                glVertex2f(100, 200);
                glVertex2f(100, 100);
            glEnd();
        glPopMatrix();
        
        // gambar lingkaran
        glPushMatrix();
            glTranslatef(500, 250, 0);
            glScalef(60, 60, 0);
            glBegin(GL_LINE_LOOP);
                glColor3f(1.0f, 0.0f, 0.0f);
                for (int i = 0 ; i <= 300 ; i++) {
                    double angle = 2 * Math.PI * i / 300;
                    double x = Math.cos(angle);
                    double y = Math.sin(angle);
                    glVertex2d(x, y);
                }
            glEnd();
        glPopMatrix();
    }
    
    public static void main(String[] args) {
        PrimitiveObject p = new PrimitiveObject();
        p.start();
    }

}
