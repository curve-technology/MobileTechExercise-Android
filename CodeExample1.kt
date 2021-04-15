class DashboardActivity: AppCompactActivity() {
  private val vm: DashboardViewModel by viewModels()
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dashboard)
    
    setupUI()
  }
  
  private fun setupUI() {
    val panel: LargePanel = findViewById(R.id.large_panel)
    
    panel.button.setOnClickListener { it: View!
      vm.showErrorMessage(activity: this, title: "Error", message: "This doesn't work!")
    }
  }
}

class DashboardViewModel: ViewModel() {
  
  fun showErrorMessage(activity: AccCompactActivity, title: String, message: String) {
    MaterialAlertDialogBuilder(activity)
    .setTitle(title)
    .setMessage(message)
    .setPositiveButton(activity.getText(android.R.string.ok)) { dialog, _ -> dialog.dismiss() }
    .show()
  }
}
                                    
