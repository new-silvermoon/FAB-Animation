# FAB-Animation

The main objective over here is to apply an animation effect on to a floating action button (FAB), which when clicked expands into a layout.

The animation is a replica of the image as displayed in the below url: 
https://stackoverflow.com/questions/29846458/how-to-animate-floating-action-button-using-android-activity-transition

Components and Implementation of the app:

1) The motion that is required to be performed by the FAB, is in semi circular or arc fashion. This can be achieved by applying the Bézier curve function.
ArcAnimation class extends the Animation class. It takes the co-ordinates as inputs and performs the Bézier curve function via "calcBezier" method.

2) Upon clicking the FAB we want a fragment to be displayed. This fragment will be custom implementation of BottomSheetDialogFragment and an AppCompatDialog.

BottomDialogFrag class extends BottomSheetDialogFragment.

AnimFrag extends BottomDialogFrag and is responsible for UI behaviour, after the creation of new fragment. It contains the implementation of the cancel button
behaviour, and is responsible for setting the Bézier curve animation effect in reverse.

BottomSheetDialog class extends AppCompatDialog.

BottomViewBehaviour class CoordinatorLayout and controls it's behaviour.

AnimatedView class is a custom implementation of FrameLayout. it is used to display the new layout upon clicking the FAB button.



All the animation related components are present in "animation" package.

3) Inside main activity, a co-ordinator layout is present along with other view groups and a FAB button.
4) Upon clicking the FAB button inside main activity, UpdatedViewFrag fragment is created and the new layout is displayed.
