import{inputFieldProperties as i,labelProperties as l,helperTextProperties as s,errorMessageProperties as p}from"./vaadin-text-field-e82c445d-1dd9e551.js";import{l as a,U as o,F as r}from"./indexhtml-8a227ef0.js";const d={tagName:"vaadin-combo-box",displayName:"ComboBox",elements:[{selector:"vaadin-combo-box::part(input-field)",displayName:"Input field",properties:i},{selector:"vaadin-combo-box::part(toggle-button)",displayName:"Toggle button",properties:[a.iconColor,a.iconSize]},{selector:"vaadin-combo-box::part(label)",displayName:"Label",properties:l},{selector:"vaadin-combo-box::part(helper-text)",displayName:"Helper text",properties:s},{selector:"vaadin-combo-box::part(error-message)",displayName:"Error message",properties:p},{selector:"vaadin-combo-box-overlay::part(overlay)",displayName:"Overlay",properties:[o.backgroundColor,o.borderColor,o.borderWidth,o.borderRadius,o.padding]},{selector:"vaadin-combo-box-overlay vaadin-combo-box-item",displayName:"Overlay items",properties:[r.textColor,r.fontSize,r.fontWeight]},{selector:"vaadin-combo-box-overlay vaadin-combo-box-item::part(checkmark)::before",displayName:"Overlay item checkmark",properties:[a.iconColor,a.iconSize]}],async setupElement(e){e.overlayClass=e.getAttribute("class"),e.items=[{label:"Item",value:"value"}],e.value="value",e.opened=!0,await new Promise(t=>setTimeout(t,10))},async cleanupElement(e){e.opened=!1}};export{d as default};
