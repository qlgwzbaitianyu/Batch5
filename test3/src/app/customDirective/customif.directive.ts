import {Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appCustomif]'
})
export class CustomifDirective {

  constructor( private templateRef: TemplateRef<any>,
               private viewContainer: ViewContainerRef) { }
  @Input() set appCustomif(condition: boolean) {
    if (condition) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainer.clear();
    }
  }

}
