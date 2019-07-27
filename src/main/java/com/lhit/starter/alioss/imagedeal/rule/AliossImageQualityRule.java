package com.lhit.starter.alioss.imagedeal.rule;

public class AliossImageQualityRule implements AliossImageRule {


    /**
     * 决定图片的相对质量，对原图按照 q% 进行质量压缩。如果原图质量是 100%，使用 90q 会得到质量为 90％ 的图片；如果原图质量是 80%，使用 90q 会得到质量72%的图片。
     *
     * 只能在原图是 jpg 格式的图片上使用，才有相对压缩的概念。如果原图为 webp，那么相对质量就相当于绝对质量。
     *
     * 取值范围 1-100
     */
    private Integer q;

    /**
     * 决定图片的绝对质量，把原图质量压到Q%，如果原图质量小于指定数字，则不压缩。如果原图质量是100%，使用“90Q”会得到质量90％的图片；如果原图质量是95%，使用“90Q”还会得到质量90%的图片；如果原图质量是80%，使用“90Q”不会压缩，返回质量80%的原图。
     *
     * 只能在保存格式为jpg/webp效果上使用，其他格式无效果。 如果同时指定了q和Q，按Q来处理。
     *
     * 取值范围 1-100
     */
    private Integer _Q;



    public AliossImageQualityRule withq(Integer q){
        this.setQ(q);
        return this;
    }

    public AliossImageQualityRule withQ(Integer Q){
        this.set_Q(Q);
        return this;
    }

    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }

    public Integer get_Q() {
        return _Q;
    }

    public void set_Q(Integer _Q) {
        this._Q = _Q;
    }



    public AliossImageQualityRule build() {
        return this;
    }

    public String buildParam() {
        String result = "quality";
        if (q != null){
            result += ",q_"+q;
        }
        if (_Q != null){
            result += ",Q_"+_Q;
        }
        return result;
    }

    public Integer getOrder() {
        return 2;
    }
}
