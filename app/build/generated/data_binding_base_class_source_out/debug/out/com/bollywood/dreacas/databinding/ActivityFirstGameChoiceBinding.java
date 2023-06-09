// Generated by view binder compiler. Do not edit!
package com.bollywood.dreacas.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bollywood.dreacas.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFirstGameChoiceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView back2;

  @NonNull
  public final ImageView background42;

  @NonNull
  public final ImageButton bonusGameButton12;

  @NonNull
  public final ImageButton buttonBack2;

  @NonNull
  public final ImageButton chooseButton12;

  @NonNull
  public final ImageView game12;

  @NonNull
  public final ImageView imageView32;

  @NonNull
  public final TextView textBonusGame2;

  @NonNull
  public final TextView textExit;

  @NonNull
  public final ImageButton triangleButtonLeft2;

  @NonNull
  public final ImageButton triangleButtonRight2;

  private ActivityFirstGameChoiceBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView back2, @NonNull ImageView background42,
      @NonNull ImageButton bonusGameButton12, @NonNull ImageButton buttonBack2,
      @NonNull ImageButton chooseButton12, @NonNull ImageView game12,
      @NonNull ImageView imageView32, @NonNull TextView textBonusGame2, @NonNull TextView textExit,
      @NonNull ImageButton triangleButtonLeft2, @NonNull ImageButton triangleButtonRight2) {
    this.rootView = rootView;
    this.back2 = back2;
    this.background42 = background42;
    this.bonusGameButton12 = bonusGameButton12;
    this.buttonBack2 = buttonBack2;
    this.chooseButton12 = chooseButton12;
    this.game12 = game12;
    this.imageView32 = imageView32;
    this.textBonusGame2 = textBonusGame2;
    this.textExit = textExit;
    this.triangleButtonLeft2 = triangleButtonLeft2;
    this.triangleButtonRight2 = triangleButtonRight2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFirstGameChoiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFirstGameChoiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_first_game_choice, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFirstGameChoiceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back_2;
      TextView back2 = ViewBindings.findChildViewById(rootView, id);
      if (back2 == null) {
        break missingId;
      }

      id = R.id.background4_2;
      ImageView background42 = ViewBindings.findChildViewById(rootView, id);
      if (background42 == null) {
        break missingId;
      }

      id = R.id.bonus_game_button1_2;
      ImageButton bonusGameButton12 = ViewBindings.findChildViewById(rootView, id);
      if (bonusGameButton12 == null) {
        break missingId;
      }

      id = R.id.button_back_2;
      ImageButton buttonBack2 = ViewBindings.findChildViewById(rootView, id);
      if (buttonBack2 == null) {
        break missingId;
      }

      id = R.id.choose_button1_2;
      ImageButton chooseButton12 = ViewBindings.findChildViewById(rootView, id);
      if (chooseButton12 == null) {
        break missingId;
      }

      id = R.id.game1_2;
      ImageView game12 = ViewBindings.findChildViewById(rootView, id);
      if (game12 == null) {
        break missingId;
      }

      id = R.id.imageView3_2;
      ImageView imageView32 = ViewBindings.findChildViewById(rootView, id);
      if (imageView32 == null) {
        break missingId;
      }

      id = R.id.text_bonus_game_2;
      TextView textBonusGame2 = ViewBindings.findChildViewById(rootView, id);
      if (textBonusGame2 == null) {
        break missingId;
      }

      id = R.id.text_exit;
      TextView textExit = ViewBindings.findChildViewById(rootView, id);
      if (textExit == null) {
        break missingId;
      }

      id = R.id.triangle_button_left_2;
      ImageButton triangleButtonLeft2 = ViewBindings.findChildViewById(rootView, id);
      if (triangleButtonLeft2 == null) {
        break missingId;
      }

      id = R.id.triangle_button_right_2;
      ImageButton triangleButtonRight2 = ViewBindings.findChildViewById(rootView, id);
      if (triangleButtonRight2 == null) {
        break missingId;
      }

      return new ActivityFirstGameChoiceBinding((ConstraintLayout) rootView, back2, background42,
          bonusGameButton12, buttonBack2, chooseButton12, game12, imageView32, textBonusGame2,
          textExit, triangleButtonLeft2, triangleButtonRight2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
