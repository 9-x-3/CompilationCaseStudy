package com.example.ggg;

        import android.os.Bundle;
        import android.text.Editable;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import java.util.Scanner;


public class PascalTriangle extends Fragment {

    private View view;
    private LinearLayout triangleLayout;
    private int numRows;
    private Button calculateButton;
    private EditText numRowsEditText;
    TextView cell;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_pascal, container, false);
        Scanner scanner = new Scanner(System.in);

        // Initialize the triangle layout
        triangleLayout = view.findViewById(R.id.triangle_layout);
        calculateButton = view.findViewById(R.id.Calculate);
        numRowsEditText = view.findViewById(R.id.numRowsEditText);
        calculateButton = view.findViewById(R.id.Calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int input = Integer.parseInt(numRowsEditText.getText().toString());
                    if(input <= 0){
                        Toast.makeText(getContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                    }else{
                        numRows = input;
                        generatePascalTriangle();
                    }
                }catch (Exception e){
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();

                }



            }
        });

        return view;
    }

    private void generatePascalTriangle() {
        triangleLayout.removeAllViews(); // Reset
        for (int row = 0; row < numRows; row++) {
            LinearLayout rowLayout = new LinearLayout(getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            rowLayout.setGravity(Gravity.CENTER_HORIZONTAL); // Center the row horizontally

            int sidePadding = (numRows - row) * 30; // Adjust the padding based on row position
            rowLayout.setPadding(sidePadding, 0, sidePadding, 0); // Add side padding to center the row

            for (int col = 0; col <= row; col++) {
                int value = calculatePascalValue(row, col);
                cell = new TextView(getContext());
                cell.setTextColor(getResources().getColor(R.color.white));
                cell.setText(String.valueOf(value));
                cell.setGravity(Gravity.CENTER);
                cell.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));

                rowLayout.addView(cell);
            }

            triangleLayout.addView(rowLayout);
        }
    }

    private int calculatePascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return calculatePascalValue(row - 1, col - 1) + calculatePascalValue(row - 1, col);
        }
    }

}