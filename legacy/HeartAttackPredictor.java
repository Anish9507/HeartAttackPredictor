import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

/**
 * Heart Attack Risk Predictor - A professional desktop application
 * Built with Java Swing for assessing heart attack risk based on user inputs
 */
public class HeartAttackPredictor extends JFrame {
    // UI Components
    private JTextField ageField;
    private JTextField weightField;
    private JComboBox<String> genderCombo;
    private JComboBox<String> chestPainCombo;
    private JComboBox<String> bloodPressureCombo;
    private JComboBox<String> cholesterolCombo;
    private JComboBox<String> diabetesCombo;
    private JComboBox<String> smokingCombo;
    private JComboBox<String> familyHistoryCombo;
    private JComboBox<String> exerciseCombo;
    private JComboBox<String> dietCombo;
    private JComboBox<String> alcoholCombo;
    private JComboBox<String> stressCombo;

    public HeartAttackPredictor() {
        initializeUI();
        setupLayout();
        setupEventHandlers();
    }

    /**
     * Initialize the main UI components and window properties
     */
    private void initializeUI() {
        setTitle("Heart Attack Risk Predictor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(600, 800);
        setLocationRelativeTo(null); // Center the window

        // Set modern font
        Font defaultFont = new Font("Segoe UI", Font.PLAIN, 12);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("Button.font", defaultFont);
        UIManager.put("TextField.font", defaultFont);
        UIManager.put("ComboBox.font", defaultFont);

        // Disable slow animations and scrolling
        UIManager.put("ScrollBar.thumb", UIManager.get("ScrollBar.thumb"));
        UIManager.put("ScrollBar.track", UIManager.get("ScrollBar.track"));
        UIManager.put("ScrollBar.thumbDarkShadow", UIManager.get("ScrollBar.thumbDarkShadow"));
        UIManager.put("ScrollBar.thumbHighlight", UIManager.get("ScrollBar.thumbHighlight"));
        UIManager.put("ScrollBar.thumbShadow", UIManager.get("ScrollBar.thumbShadow"));

        // Set faster scrolling speed
        UIManager.put("ScrollBar.maximumThumbSize", new Dimension(50, 50));
        UIManager.put("ScrollBar.minimumThumbSize", new Dimension(20, 20));

        // Disable slow animations
        UIManager.put("Button.select", UIManager.get("Button.select"));
        UIManager.put("ComboBox.select", UIManager.get("ComboBox.select"));
        UIManager.put("TextField.select", UIManager.get("TextField.select"));
    }

    /**
     * Setup the main layout with proper spacing and alignment
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        // Title panel
        JPanel titlePanel = createTitlePanel();
        add(titlePanel, BorderLayout.NORTH);

        // Main content panel with scrollable form
        JScrollPane scrollPane = createScrollableForm();
        add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        // Add padding around the entire window
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Create the title panel with application name
     */
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Heart Attack Risk Predictor");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));

        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        return titlePanel;
    }

    /**
     * Create the scrollable form with all input fields
     */
    private JScrollPane createScrollableForm() {
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Personal Information Section
    formPanel.add(createSectionLabel("Personal Information"));
    formPanel.add(createInputRow("Age:", createAgeField()));
    formPanel.add(createInputRow("Body Weight (kg):", createWeightField()));
    formPanel.add(createInputRow("Gender:", createGenderCombo()));

    formPanel.add(Box.createVerticalStrut(20));

    // Health Information Section
    formPanel.add(createSectionLabel("Health Information"));
    formPanel.add(createInputRow("Chest pain or shortness of breath:", createChestPainCombo()));
    formPanel.add(createInputRow("High blood pressure:", createBloodPressureCombo()));
    formPanel.add(createInputRow("High cholesterol:", createCholesterolCombo()));
    formPanel.add(createInputRow("Diabetes:", createDiabetesCombo()));
    formPanel.add(createInputRow("Smoke regularly:", createSmokingCombo()));
    formPanel.add(createInputRow("Family history of heart disease:", createFamilyHistoryCombo()));

    formPanel.add(Box.createVerticalStrut(20));

    // Lifestyle Information Section
    formPanel.add(createSectionLabel("Lifestyle Information"));
    formPanel.add(createInputRow("Exercise frequency:", createExerciseCombo()));
    formPanel.add(createInputRow("Diet type:", createDietCombo()));
    formPanel.add(createInputRow("Alcohol consumption:", createAlcoholCombo()));
    formPanel.add(createInputRow("Stress level:", createStressCombo()));

    // ✅ Wrap formPanel inside a centering container
    JPanel centerWrapper = new JPanel(new GridBagLayout());
    centerWrapper.add(formPanel);

    JScrollPane scrollPane = new JScrollPane(centerWrapper);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(null);

    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    scrollPane.getVerticalScrollBar().setBlockIncrement(64);

    return scrollPane;
}


    /**
     * Create a section label with proper styling
     */
    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(70, 130, 180));
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    /**
     * Create an input row with label and input component
     */
    private JPanel createInputRow(String labelText, JComponent inputComponent) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(250, 25));
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        inputComponent.setPreferredSize(new Dimension(200, 25));
        inputComponent.setMaximumSize(new Dimension(200, 25));

        row.add(label);
        row.add(Box.createHorizontalStrut(20));
        row.add(inputComponent);

        return row;
    }

    /**
     * Create input fields and combo boxes
     */
    private JTextField createAgeField() {
        ageField = new JTextField();
        ageField.setToolTipText("Enter your age in years");
        return ageField;
    }

    private JTextField createWeightField() {
        weightField = new JTextField();
        weightField.setToolTipText("Enter your weight in kilograms");
        return weightField;
    }

    private JComboBox<String> createGenderCombo() {
        genderCombo = new JComboBox<>(new String[]{"Select Gender", "Male", "Female"});
        return genderCombo;
    }

    private JComboBox<String> createChestPainCombo() {
        chestPainCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return chestPainCombo;
    }

    private JComboBox<String> createBloodPressureCombo() {
        bloodPressureCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return bloodPressureCombo;
    }

    private JComboBox<String> createCholesterolCombo() {
        cholesterolCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return cholesterolCombo;
    }

    private JComboBox<String> createDiabetesCombo() {
        diabetesCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return diabetesCombo;
    }

    private JComboBox<String> createSmokingCombo() {
        smokingCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return smokingCombo;
    }

    private JComboBox<String> createFamilyHistoryCombo() {
        familyHistoryCombo = new JComboBox<>(new String[]{"Select", "Yes", "No"});
        return familyHistoryCombo;
    }

    private JComboBox<String> createExerciseCombo() {
        exerciseCombo = new JComboBox<>(new String[]{"Select", "Daily", "3-5 times a week", "Rarely", "Never"});
        return exerciseCombo;
    }

    private JComboBox<String> createDietCombo() {
        dietCombo = new JComboBox<>(new String[]{"Select", "Balanced", "High fat", "High sugar", "Low fiber"});
        return dietCombo;
    }

    private JComboBox<String> createAlcoholCombo() {
        alcoholCombo = new JComboBox<>(new String[]{"Select", "No", "Occasionally", "Regularly"});
        return alcoholCombo;
    }

    private JComboBox<String> createStressCombo() {
        stressCombo = new JComboBox<>(new String[]{"Select", "Yes", "Sometimes", "No"});
        return stressCombo;
    }

    /**
     * Create the button panel with the main action button
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JButton checkRiskButton = new JButton("Check My Risk");
        checkRiskButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        checkRiskButton.setPreferredSize(new Dimension(150, 40));
        checkRiskButton.setBackground(new Color(70, 130, 180));
        checkRiskButton.setForeground(Color.WHITE);
        checkRiskButton.setFocusPainted(false);
        checkRiskButton.setBorderPainted(false);

        // Add hover effect
        checkRiskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkRiskButton.setBackground(new Color(100, 149, 237));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkRiskButton.setBackground(new Color(70, 130, 180));
            }
        });

        buttonPanel.add(checkRiskButton);

        return buttonPanel;
    }

    /**
     * Setup event handlers for the application
     */
    private void setupEventHandlers() {
        // Get the check risk button and add action listener
        JPanel buttonPanel = (JPanel) ((BorderLayout) getContentPane().getLayout()).getLayoutComponent(BorderLayout.SOUTH);
        JButton checkRiskButton = (JButton) buttonPanel.getComponent(0);

        checkRiskButton.addActionListener(new ActionListener() {
            @Override
# truncated for brevity in this legacy file
