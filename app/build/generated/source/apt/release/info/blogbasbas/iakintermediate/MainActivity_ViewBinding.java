// Generated code from Butter Knife. Do not modify!
package info.blogbasbas.iakintermediate;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.namaresep = Utils.findRequiredViewAsType(source, R.id.namaresep, "field 'namaresep'", TextView.class);
    target.detailresep = Utils.findRequiredViewAsType(source, R.id.detailresep, "field 'detailresep'", TextView.class);
    target.rvDataResep = Utils.findRequiredViewAsType(source, R.id.rvDataResep, "field 'rvDataResep'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.namaresep = null;
    target.detailresep = null;
    target.rvDataResep = null;
  }
}
