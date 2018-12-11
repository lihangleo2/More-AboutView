package comt.leo.picker.moreaboutview.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

import comt.leo.picker.moreaboutview.utils.BezierUtil;


public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF mControlPoint;

    public BezierEvaluator(PointF controlPoint) {
        this.mControlPoint = controlPoint;
    }

    @Override
    public PointF evaluate(float t, PointF startValue, PointF endValue) {
        return BezierUtil.CalculateBezierPointForQuadratic(t, startValue, mControlPoint, endValue);
    }
}