// Generated code from Butter Knife. Do not modify!
package info.blogbasbas.iakintermediate;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CRUDActivity_ViewBinding implements Unbinder {
  private CRUDActivity target;

  private View view2131230758;

  private View view2131230760;

  private View view2131230757;

  private View view2131230759;

  @UiThread
  public CRUDActivity_ViewBinding(CRUDActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CRUDActivity_ViewBinding(final CRUDActivity target, View source) {
    this.target = target;

    View view;
    target.edtNama = Utils.findRequiredViewAsType(source, R.id.edt_nama, "field 'edtNama'", EditText.class);
    target.edtResep = Utils.findRequiredViewAsType(source, R.id.edtResep, "field 'edtResep'", EditText.class);
    target.edtGambar = Utils.findRequiredViewAsType(source, R.id.edt_gambar, "field 'edtGambar'", EditText.class);
    target.pd = Utils.findRequiredViewAsType(source, R.id.pd, "field 'pd'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.btn_insertdata, "field 'btnInsertdata' and method 'onViewClicked'");
    target.btnInsertdata = Utils.castView(view, R.id.btn_insertdata, "field 'btnInsertdata'", Button.class);
    view2131230758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btntampildata, "field 'btntampildata' and method 'onViewClicked'");
    target.btntampildata = Utils.castView(view, R.id.btntampildata, "field 'btntampildata'", Button.class);
    view2131230760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnUpdate, "field 'btnUpdate' and method 'onViewClicked'");
    target.btnUpdate = Utils.castView(view, R.id.btnUpdate, "field 'btnUpdate'", Button.class);
    view2131230757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnhapus, "field 'btnhapus' and method 'onViewClicked'");
    target.btnhapus = Utils.castView(view, R.id.btnhapus, "field 'btnhapus'", Button.class);
    view2131230759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CRUDActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtNama = null;
    target.edtResep = null;
    target.edtGambar = null;
    target.pd = null;
    target.btnInsertdata = null;
    target.btntampildata = null;
    target.btnUpdate = null;
    target.btnhapus = null;

    view2131230758.setOnClickListener(null);
    view2131230758 = null;
    view2131230760.setOnClickListener(null);
    view2131230760 = null;
    view2131230757.setOnClickListener(null);
    view2131230757 = null;
    view2131230759.setOnClickListener(null);
    view2131230759 = null;
  }
}
