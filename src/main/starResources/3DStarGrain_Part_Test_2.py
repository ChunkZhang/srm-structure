# -*- coding: mbcs -*-
#
# Abaqus/CAE Release 6.14-1 replay file
# Internal Version: 2014_06_05-06.11.02 134264
# Run by chunk on Mon Jun 27 16:11:03 2016
#

# from driverUtils import executeOnCaeGraphicsStartup
# executeOnCaeGraphicsStartup()
#: Executing "onCaeGraphicsStartup()" in the site directory ...
from abaqus import *
from abaqusConstants import *
# session.Viewport(name='Viewport: 1', origin=(0.0, 0.0), width=209.040618896484, 
#     height=139.163330078125)
# session.viewports['Viewport: 1'].makeCurrent()
# session.viewports['Viewport: 1'].maximize()
from caeModules import *
from driverUtils import executeOnCaeStartup
executeOnCaeStartup()
# session.viewports['Viewport: 1'].partDisplay.geometryOptions.setValues(
#     referenceRepresentation=ON)
Mdb()
#: 新的模型数据库已创建.
#: 模型 "Model-1" 已创建.
# session.viewports['Viewport: 1'].setValues(displayedObject=None)
s = mdb.models['Model-1'].ConstrainedSketch(name='__profile__', 
    sheetSize=400.0)
g, v, d, c = s.geometry, s.vertices, s.dimensions, s.constraints
s.setPrimaryObject(option=STANDALONE)




# session.journalOptions.setValues(replayGeometry=INDEX,recoverGeometry=INDEX)

InnerRadius = 0
StarNum = 6
StarCoefficient = 0.8
OuterRadius = 500
FeatureLength = 200
ArcRadius = 20
StarAngle = 80.0
StarArcRadius = 15
EllipseXAxis = OuterRadius-InnerRadius
EllipseYAxis = 200
GrainLength = 1500 


PoissonRatio = 0.48
Expansion1 = 9.5e-05
Density1 = 1.77e-09
Modulus = 5.25
PronyTable1 = (0.408, 0.408, 5.54)
PronyTable2 = (0.286, 0.286, 55.42)
PronyTable3 = (0.13, 0.13, 554.17)
TrsTable = (20.0, 20.0, 573.0)

TemperatureOriginal = 73
TemperatureFinal = 20
Time = 190800.0

PressureTime = 0.1
PressureMax = 10



# mdb.models['Model-1'].Material(name='Material-1')
# mdb.models['Model-1'].materials['Material-1'].Density(table=((Density1, ), ))
# mdb.models['Model-1'].materials['Material-1'].Elastic(table=((Modulus , PoissonRatio), ))
# mdb.models['Model-1'].materials['Material-1'].Viscoelastic(domain=TIME, 
    # time=PRONY, table=(PronyTable1, PronyTable2, PronyTable3))
# mdb.models['Model-1'].materials['Material-1'].viscoelastic.Trs(table=(TrsTable, ))
# mdb.models['Model-1'].materials['Material-1'].Expansion(table=((Expansion1, ), ))



Theta = pi/2-pi/StarNum
CTheta = Theta+StarCoefficient*pi/StarNum
PointOriginal = (0,0)
PointOuter1 = (0,OuterRadius)
PointOuter2 = (OuterRadius*cos(Theta),OuterRadius*sin(Theta))
L = FeatureLength+ArcRadius
PointInner1 = (0,L)
PointInner2 = (L*cos(CTheta),L*sin(CTheta))
PointOriginalAR = (FeatureLength*cos(CTheta),FeatureLength*sin(CTheta))
SATheta = pi/2-pi/StarNum+StarAngle/(2*180)*pi # 100
SAThetaCZ = SATheta-pi/2 # 10
PointInner3 = (FeatureLength*cos(CTheta)+ArcRadius*cos(SAThetaCZ),
	FeatureLength*sin(CTheta)+ArcRadius*sin(SAThetaCZ))
	
	
x = (tan(SATheta)*PointInner3[0]-PointInner3[1])/(tan(SATheta)-tan(Theta))#星角点坐标
PointStarA = (x, x*tan(Theta))



PointNotExist1 = (PointInner3[0]+StarArcRadius*cos(SAThetaCZ),
	PointInner3[1]+StarArcRadius*sin(SAThetaCZ))
x = (tan(SATheta)*PointNotExist1[0]-PointNotExist1[1])/(tan(SATheta)-tan(Theta))
PointOriginalSAR = (x, x*tan(Theta))
PointStarAR1 = (PointOriginalSAR[0]-StarArcRadius*cos(SAThetaCZ),
	PointOriginalSAR[1]-StarArcRadius*sin(SAThetaCZ))
PointStarAR2 = (PointOriginalSAR[0]-StarArcRadius*cos(Theta),
	PointOriginalSAR[1]-StarArcRadius*sin(Theta))



s.Line(point1=PointInner1, point2=PointOriginal)

# s.ArcByCenterEnds(center=PointOriginal, point1=PointOuter1, 
# 	point2=PointOuter2, direction=CLOCKWISE)

s.ArcByCenterEnds(center=PointOriginal, point1=PointInner1, 
	point2=PointInner2, direction=CLOCKWISE)
	
s.ArcByCenterEnds(center=PointOriginalAR, point1=PointInner2, 
	point2=PointInner3, direction=CLOCKWISE)

s.Line(point1=PointInner3, point2=PointStarAR1)
# COUNTERCLOCKWISE
s.ArcByCenterEnds(center=PointOriginalSAR, point1=PointStarAR1, 
	point2=PointStarAR2, direction=COUNTERCLOCKWISE)

s.Line(point1=PointStarAR2, point2=PointOriginal)




p = mdb.models['Model-1'].Part(name='Part-1', dimensionality=THREE_D, 
    type=DEFORMABLE_BODY)
p = mdb.models['Model-1'].parts['Part-1']
p.BaseSolidExtrude(sketch=s, depth=GrainLength)
s.unsetPrimaryObject()
p = mdb.models['Model-1'].parts['Part-1']
session.viewports['Viewport: 1'].setValues(displayedObject=p)
del mdb.models['Model-1'].sketches['__profile__']






s1 = mdb.models['Model-1'].ConstrainedSketch(name='__profile__', 
    sheetSize=200.0)
g, v, d, c = s1.geometry, s1.vertices, s1.dimensions, s1.constraints


s1.sketchOptions.setValues(viewStyle=AXISYM)
s1.setPrimaryObject(option=STANDALONE)
s1.ConstructionLine(point1=(0.0, -200.0), point2=(0.0, 200.0))
s1.FixedConstraint(entity=g[2])

s1.ConstructionLine(point1=(0.0, 0.0), angle=0.0)
s1.HorizontalConstraint(entity=g[3], addUndoState=False)
s1.ConstructionLine(point1=(0.0, 0.0), angle=90.0)


s1.VerticalConstraint(entity=g[4], addUndoState=False)
s1.ConstructionLine(point1=(InnerRadius, 0.0), angle=90.0)
s1.VerticalConstraint(entity=g[5], addUndoState=False)
s1.ConstructionLine(point1=(OuterRadius, 0.0), angle=90.0)
s1.VerticalConstraint(entity=g[6], addUndoState=False)
s1.ConstructionLine(point1=(0.0, EllipseYAxis), angle=0.0)
s1.HorizontalConstraint(entity=g[7], addUndoState=False)
s1.ConstructionLine(point1=(0.0, GrainLength-EllipseYAxis), angle=0.0)
s1.HorizontalConstraint(entity=g[8], addUndoState=False)



s1.Line(point1=(InnerRadius, 0.0), point2=(InnerRadius, GrainLength))

s1.VerticalConstraint(entity=g[9], addUndoState=False)
s1.PerpendicularConstraint(entity1=g[3], entity2=g[9], addUndoState=False)
s1.CoincidentConstraint(entity1=v[0], entity2=g[3], addUndoState=False)

s1.Line(point1=(OuterRadius, EllipseYAxis), point2=(OuterRadius, GrainLength-EllipseYAxis))
s1.VerticalConstraint(entity=g[10], addUndoState=False)
s1.ParallelConstraint(entity1=g[6], entity2=g[10], addUndoState=False)
s1.CoincidentConstraint(entity1=v[2], entity2=g[6], addUndoState=False)
s1.CoincidentConstraint(entity1=v[3], entity2=g[6], addUndoState=False)
s1.EllipseByCenterPerimeter(center=(InnerRadius, GrainLength-EllipseYAxis), axisPoint1=(InnerRadius, GrainLength), 
    axisPoint2=(OuterRadius, GrainLength-EllipseYAxis))
    
s1.CoincidentConstraint(entity1=v[5], entity2=g[5], addUndoState=False)

x1=EllipseXAxis/2+InnerRadius   
s1.breakCurve(curve1=g[11], point1=(x1, GrainLength-EllipseYAxis+EllipseYAxis*(1-((x1-InnerRadius)/EllipseXAxis)**2)**0.5), 
    curve2=g[8], point2=(InnerRadius+1, GrainLength-EllipseYAxis))
s1.delete(objectList=(g[13], ))
s1.EllipseByCenterPerimeter(center=(InnerRadius, EllipseYAxis), axisPoint1=(InnerRadius, 0.0), 
    axisPoint2=(OuterRadius, EllipseYAxis))

s1.CoincidentConstraint(entity1=v[8], entity2=g[5], addUndoState=False)


#x1, EllipseYAxis+EllipseYAxis*(1-((x1-InnerRadius)/EllipseXAxis)**2)**0.5

s1.breakCurve(curve1=g[15], point1=(x1, EllipseYAxis+EllipseYAxis*(1-((x1-InnerRadius)/EllipseXAxis)**2)**0.5), 
    curve2=g[5], point2=(InnerRadius, EllipseYAxis+1))
s1.breakCurve(curve1=g[17], point1=(x1, EllipseYAxis+EllipseYAxis*(1-((x1-InnerRadius)/EllipseXAxis)**2)**0.5), 
    curve2=g[7], point2=(OuterRadius+1, EllipseYAxis))
s1.delete(objectList=(g[18], g[20]))




p = mdb.models['Model-1'].Part(name='Part-2', dimensionality=THREE_D, 
    type=DEFORMABLE_BODY)
p = mdb.models['Model-1'].parts['Part-2']
p.BaseSolidRevolve(sketch=s1, angle=180/StarNum, flipRevolveDirection=OFF)
s1.unsetPrimaryObject()
p = mdb.models['Model-1'].parts['Part-2']
session.viewports['Viewport: 1'].setValues(displayedObject=p)
del mdb.models['Model-1'].sketches['__profile__']

session.viewports['Viewport: 1'].setValues(displayedObject=None)
a = mdb.models['Model-1'].rootAssembly
session.viewports['Viewport: 1'].setValues(displayedObject=a)
session.viewports['Viewport: 1'].assemblyDisplay.setValues(
    optimizationTasks=OFF, geometricRestrictions=OFF, stopConditions=OFF)
a = mdb.models['Model-1'].rootAssembly
a.DatumCsysByDefault(CARTESIAN)
p = mdb.models['Model-1'].parts['Part-1']
a.Instance(name='Part-1-1', part=p, dependent=ON)
p = mdb.models['Model-1'].parts['Part-2']
a.Instance(name='Part-2-1', part=p, dependent=ON)
#: 视口 "Viewport: 1" 的内容已复制到剪贴板.
a = mdb.models['Model-1'].rootAssembly
a.rotate(instanceList=('Part-2-1', ), axisPoint=(0.0, 0.0, 0.0), 
    axisDirection=(1.0, 0.0, 0.0), angle=90.0)
#: The instance Part-2-1 was rotated by 90. 度(关于由点 0., 0., 0. 和向量 1., 0., 0. 定义的轴线)
a = mdb.models['Model-1'].rootAssembly
a.rotate(instanceList=('Part-2-1', ), axisPoint=(0.0, 0.0, 0.0), 
    axisDirection=(0.0, 0.0, 1.0), angle=90.0)
#: The instance Part-2-1 was rotated by 90. 度(关于由点 0., 0., 0. 和向量 0., 0., 1. 定义的轴线)
a = mdb.models['Model-1'].rootAssembly
a.InstanceFromBooleanCut(name='Part-3', 
    instanceToBeCut=mdb.models['Model-1'].rootAssembly.instances['Part-2-1'], 
    cuttingInstances=(a.instances['Part-1-1'], ), originalInstances=SUPPRESS)


mdb.models['Model-1'].Material(name='Material-1')
mdb.models['Model-1'].materials['Material-1'].Density(table=((Density1, ), ))
mdb.models['Model-1'].materials['Material-1'].Elastic(table=((Modulus , PoissonRatio), ))
mdb.models['Model-1'].materials['Material-1'].Viscoelastic(domain=TIME, 
    time=PRONY, table=(PronyTable1, PronyTable2, PronyTable3))
mdb.models['Model-1'].materials['Material-1'].viscoelastic.Trs(table=(TrsTable, ))
mdb.models['Model-1'].materials['Material-1'].Expansion(table=((Expansion1, ), ))




mdb.models['Model-1'].ViscoStep(name='Step-1', previous='Initial', 
    timePeriod=Time, maxNumInc=10000, initialInc=1000.0, minInc=Time/100000, 
    maxInc=100000.0, cetol=0.01)
mdb.models['Model-1'].ImplicitDynamicsStep(name='Step-2', previous='Step-1',
    timePeriod=PressureTime, maxNumInc=1000, initialInc=PressureTime/10, minInc=1e-06)

a = mdb.models['Model-1'].rootAssembly  
a.DatumCsysByThreePoints(name='Datum csys-2', coordSysType=CYLINDRICAL, 
    origin=(0.0, 0.0, 0.0), point1=(0.0, 1.0, 0.0), point2=(1.0, 0.0, 0.0))
a = mdb.models['Model-1'].rootAssembly  




mdb.models['Model-1'].TabularAmplitude(name='Amp-1', timeSpan=STEP,
    smooth=SOLVER_DEFAULT, data=((0.0, TemperatureOriginal), (Time, TemperatureFinal)))

    
mdb.models['Model-1'].TabularAmplitude(name='Amp-2', timeSpan=STEP, 
    smooth=SOLVER_DEFAULT, data=((0.0, 0.0), (PressureTime, PressureMax)))

mdb.models['Model-1'].HomogeneousSolidSection(name='Section-1', 
    material='Material-1', thickness=None)

p = mdb.models['Model-1'].parts['Part-3']
c = p.cells
cells = c[0:1]
region = p.Set(cells=cells, name='Set-1')
p = mdb.models['Model-1'].parts['Part-3']
p.SectionAssignment(region=region, sectionName='Section-1', offset=0.0, 
    offsetType=MIDDLE_SURFACE, offsetField='', 
    thicknessAssignment=FROM_SECTION)
a1 = mdb.models['Model-1'].rootAssembly
a1.regenerate()



# 压力
a = mdb.models['Model-1'].rootAssembly
s1 = a.instances['Part-3-1'].faces
side1Faces1 = s1[0:5]+s1[6:7]
region = a.Surface(side1Faces=side1Faces1, name='Surf-1')
mdb.models['Model-1'].Pressure(name='Load-1', createStepName='Step-2', 
    region=region, distributionType=UNIFORM, field='', magnitude=1.0, 
    amplitude='Amp-2')

# 固支
session.viewports['Viewport: 1'].assemblyDisplay.setValues(step='Initial')
a = mdb.models['Model-1'].rootAssembly
f1 = a.instances['Part-3-1'].faces
faces1 = f1[7:8]
region = a.Set(faces=faces1, name='Set-1')
datum = mdb.models['Model-1'].rootAssembly.datums[8]
mdb.models['Model-1'].EncastreBC(name='BC-1', createStepName='Initial', 
    region=region, localCsys=datum)


# 对称

a = mdb.models['Model-1'].rootAssembly
f1 = a.instances['Part-3-1'].faces
faces1 = f1[5:6]+f1[8:9]
region = a.Set(faces=faces1, name='Set-2')
datum = mdb.models['Model-1'].rootAssembly.datums[8]
mdb.models['Model-1'].YsymmBC(name='BC-2', createStepName='Initial', 
    region=region, localCsys=datum)



# 预定义场

a = mdb.models['Model-1'].rootAssembly
c1 = a.instances['Part-3-1'].cells
cells1 = c1[0:1]
f1 = a.instances['Part-3-1'].faces
faces1 = f1[0:9]
e1 = a.instances['Part-3-1'].edges
edges1 = e1[0:21]
v1 = a.instances['Part-3-1'].vertices
verts1 = v1[0:14]
region = a.Set(vertices=verts1, edges=edges1, faces=faces1, cells=cells1, 
    name='Set-3')
mdb.models['Model-1'].Temperature(name='Predefined Field-1', 
    createStepName='Initial', region=region, distributionType=UNIFORM, 
    crossSectionDistribution=CONSTANT_THROUGH_THICKNESS, magnitudes=(TemperatureOriginal, ))
mdb.models['Model-1'].predefinedFields['Predefined Field-1'].setValuesInStep(
    stepName='Step-1', magnitudes=(1.0, ), amplitude='Amp-1')
mdb.models['Model-1'].predefinedFields['Predefined Field-1'].setValuesInStep(
    stepName='Step-2', magnitudes=(TemperatureFinal, ), amplitude=FREED)



# 网格
p = mdb.models['Model-1'].parts['Part-3']
p.seedPart(size=20.0, deviationFactor=0.1, minSizeFactor=0.1)
p = mdb.models['Model-1'].parts['Part-3']
p.generateMesh()