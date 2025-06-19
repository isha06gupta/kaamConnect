package com.kaamConnect.KaamConnect.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form")
@CrossOrigin
public class FormController {

    @GetMapping("/worker")
    public String getWorkerForm(@RequestParam(defaultValue = "en") String lang) {
        String fullName = lang.equals("hi") ? "पूरा नाम" : "Full Name";
        String age = lang.equals("hi") ? "आयु" : "Age";
        String skillType = lang.equals("hi") ? "कौशल प्रकार" : "Skill Type";
        String mobileNumber = lang.equals("hi") ? "मोबाइल नंबर" : "Mobile Number";
        String address = lang.equals("hi") ? "पता" : "Address";
        String experienceYears = lang.equals("hi") ? "अनुभव (वर्षों में)" : "Experience (years)";
        String registerBtn = lang.equals("hi") ? "पंजीकरण करें" : "Register";
        String worker = lang.equals("hi") ? "कामगार पंजीकरण" : "Worker Registration";

        return """
            <form onsubmit="submitForm(event, 'worker')">
                <h2>%s</h2>
                <label>%s</label>
                <input name="fullName" placeholder="%s" required>
                <label>%s</label>
                <input name="age" type="number" placeholder="%s" required>
                <label>%s</label>
                <input name="skillType" placeholder="%s" required>
                <label>%s</label>
                <input name="mobileNumber" placeholder="%s" required>
                <label>%s</label>
                <input name="address" placeholder="%s" required>
                <label>%s</label>
                <input name="experienceYears" type="number" placeholder="%s" required>
                <button type="submit">%s</button>
            </form>
        """.formatted(worker, fullName, fullName, age, age, skillType, skillType, mobileNumber, mobileNumber, address, address, experienceYears, experienceYears, registerBtn);
    }

    @GetMapping("/employer")
    public String getEmployerForm(@RequestParam(defaultValue = "en") String lang) {
        String organizationName = lang.equals("hi") ? "संगठन का नाम" : "Organization Name";
        String contactPerson = lang.equals("hi") ? "संपर्क व्यक्ति" : "Contact Person";
        String email = lang.equals("hi") ? "ईमेल" : "Email";
        String jobPosition = lang.equals("hi") ? "नौकरी की स्थिति" : "Job Position";
        String requiredSkill = lang.equals("hi") ? "आवश्यक कौशल" : "Required Skill";
        String jobLocation = lang.equals("hi") ? "नौकरी स्थान" : "Job Location";
        String registerBtn = lang.equals("hi") ? "पंजीकरण करें" : "Register";
        String employer = lang.equals("hi") ? "नियोक्ता पंजीकरण" : "Employer Registration";

        return """
            <form onsubmit="submitForm(event, 'employer')">
                <h2>%s</h2>
                <label>%s</label>
                <input name="organizationName" placeholder="%s" required>
                <label>%s</label>
                <input name="contactPerson" placeholder="%s" required>
                <label>%s</label>
                <input name="email" type="email" placeholder="%s" required>
                <label>%s</label>
                <input name="jobPosition" placeholder="%s" required>
                <label>%s</label>
                <input name="requiredSkill" placeholder="%s" required>
                <label>%s</label>
                <input name="jobLocation" placeholder="%s" required>
                <button type="submit">%s</button>
            </form>
        """.formatted(employer, organizationName, organizationName, contactPerson, contactPerson, email, email, jobPosition, jobPosition, requiredSkill, requiredSkill, jobLocation, jobLocation, registerBtn);
    }

    @GetMapping("/ngo")
    public String getNGOForm(@RequestParam(defaultValue = "en") String lang) {
        String ngoName = lang.equals("hi") ? "एनजीओ का नाम" : "NGO Name";
        String registrationNumber = lang.equals("hi") ? "पंजीकरण संख्या" : "Registration Number";
        String contactPerson = lang.equals("hi") ? "संपर्क व्यक्ति" : "Contact Person";
        String email = lang.equals("hi") ? "ईमेल" : "Email";
        String contactNumber = lang.equals("hi") ? "संपर्क नंबर" : "Contact Number";
        String address = lang.equals("hi") ? "पता" : "Address";
        String focusArea = lang.equals("hi") ? "केंद्रित क्षेत्र" : "Focus Area";
        String registerBtn = lang.equals("hi") ? "पंजीकरण करें" : "Register";
        String ngo = lang.equals("hi") ? "एनजीओ पंजीकरण" : "NGO Registration";

        return """
            <form onsubmit="submitForm(event, 'ngo')">
                <h2>%s</h2>
                <label>%s</label>
                <input name="ngoName" placeholder="%s" required>
                <label>%s</label>
                <input name="registrationNumber" placeholder="%s" required>
                <label>%s</label>
                <input name="contactPerson" placeholder="%s" required>
                <label>%s</label>
                <input name="email" type="email" placeholder="%s" required>
                <label>%s</label>
                <input name="contactNumber" placeholder="%s" required>
                <label>%s</label>
                <input name="address" placeholder="%s" required>
                <label>%s</label>
                <input name="focusArea" placeholder="%s" required>
                <button type="submit">%s</button>
            </form>
        """.formatted(ngo, ngoName, ngoName, registrationNumber, registrationNumber, contactPerson, contactPerson, email, email, contactNumber, contactNumber, address, address, focusArea, focusArea, registerBtn);
    }
}