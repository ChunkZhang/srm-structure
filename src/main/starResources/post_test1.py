# -*- coding: mbcs -*-

from abaqus import *
from abaqusConstants import *
import visualization




myViewport = session.Viewport(name='Whatever Viewport',
    origin=(0, 0), width=150, height=100)
	
myOdb = visualization.openOdb(path='Job-1.odb')

myViewport.setValues(displayedObject=myOdb)


#窗口最大化
session.viewports['Whatever Viewport'].makeCurrent()
session.viewports['Whatever Viewport'].maximize()
session.viewports['Viewport: 1'].restore()
session.viewports['Whatever Viewport'].maximize()
#-----------------------------------------------


session.viewports['Whatever Viewport'].odbDisplay.display.setValues(plotState=(
    CONTOURS_ON_UNDEF, ))
session.viewports['Whatever Viewport'].view.setValues(session.views['Iso'])
session.viewports['Whatever Viewport'].view.rotate(xAngle=5, yAngle=-20, 
    zAngle=190, mode=MODEL)
session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/smises2', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))


session.viewports['Whatever Viewport'].odbDisplay.setPrimaryVariable(
    variableLabel='U', outputPosition=NODAL, refinement=(INVARIANT, 
    'Magnitude'), )

session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/uall2', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))

session.viewports['Whatever Viewport'].odbDisplay.setPrimaryVariable(
    variableLabel='E', outputPosition=INTEGRATION_POINT, refinement=(INVARIANT, 
    'Max. Principal'), )

session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/eprincipal2', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))


session.viewports[session.currentViewportName].odbDisplay.setFrame(
    step='Step-1', frame=-1)
session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/eprincipal1', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))


session.viewports['Whatever Viewport'].odbDisplay.setPrimaryVariable(
    variableLabel='S', outputPosition=INTEGRATION_POINT, refinement=(INVARIANT, 
    'Mises'), )
session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/smises1', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))


session.viewports['Whatever Viewport'].odbDisplay.setPrimaryVariable(
    variableLabel='U', outputPosition=NODAL, refinement=(INVARIANT, 
    'Magnitude'), )
session.printToFile(
    fileName='C:/Users/chunk/Desktop/java/NetBeans/3D_TEST_1/src/test1/runtime/uall1', 
    format=PNG, canvasObjects=(session.viewports['Whatever Viewport'], 
    session.viewports['Viewport: 1']))




# myViewport.odbDisplay.setPrimaryVariable(variableLabel='E', 
# 	outputPosition=INTEGRATION_POINT, 
# 	refinement=(INVARIANT, 'Max. In-Plane Principal'))
# myViewport.odbDisplay.display.setValues(plotState=CONTOURS_ON_DEF)
# myViewport.odbDisplay.setFrame(step='Step-1', frame=-1)

# session.viewports['Viewport: 1'].view.setValues(session.views['Iso'])
# session.viewports['Viewport: 1'].view.rotate(xAngle=5, yAngle=-20, zAngle=190, 
#     mode=MODEL)

# session.printToFile(fileName='strains', format=PNG, canvasObjects=(
#     session.viewports['Whatever Viewport'], 
#     session.viewports['Viewport: 1']))

