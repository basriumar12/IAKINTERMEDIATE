// Generated code from Butter Knife. Do not modify!
package info.blogbasbas.iakintermediate;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailActivity_ViewBinding implements Unbinder {
  private DetailActivity target;

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target, View source) {
    this.target = target;

    target.imgmakanan = Utils.findRequiredViewAsType(source, R.id.imgmakanan, "field 'imgmakanan'", ImageView.class);
    target.txtnama = Utils.findRequiredViewAsType(source, R.id.txtnama, "field 'txtnama'", TextView.class);
    target.txtdetail = Utils.findRequiredViewAsType(source, R.id.txtdetail, "field 'txtdetail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgmakanan = null;
    target.txtnama = null;
    target.txtdetail = null;
  }
}
